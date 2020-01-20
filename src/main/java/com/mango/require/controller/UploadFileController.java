package com.mango.require.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import com.mango.require.service.IUploadFileService;
import com.mango.require.model.UploadFile;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import com.mango.require.model.common.PageResponse;
import javax.annotation.Resource;

/**
 * <p>
 * 文件信息 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Api(value = "文件信息接口", tags = {"文件信息接口"})
@Slf4j
@RestController
@RequestMapping("/upload-file")
public class UploadFileController {

     @Resource
     private IUploadFileService uploadFileService;

     /**
      * 文件信息列表
      * @param uploadFile 文件信息
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "文件信息列表", notes = "文件信息列表")
     @PreAuthorize("hasAuthority('uploadFile:view')")
     @GetMapping
     public Result list(UploadFile uploadFile, PageRequest pageRequest) {
          QueryWrapper<UploadFile> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          Page<UploadFile> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
          IPage<UploadFile> uploadFilePage = uploadFileService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<UploadFile>builder().list(uploadFilePage.getRecords()).total(uploadFilePage.getTotal()).build());
     }

     /**
      * 文件信息新增
      * @param uploadFile 文件信息
      * @return Result
      */
     @ApiOperation(value = "文件信息新增", notes = "文件信息新增")
     @PreAuthorize("hasAuthority('uploadFile:add')")
     @PostMapping
     public Result add(UploadFile uploadFile) {
          return ResultGenerator.genSuccessResult(uploadFileService.save(uploadFile));
     }

     /**
      * 文件信息删除
      * @param id 文件信息主键
      * @return Result
      */
     @ApiOperation(value = "文件信息删除", notes = "文件信息删除")
     @PreAuthorize("hasAuthority('uploadFile:delete')")
     @DeleteMapping("/{id: \\d+}")
     public Result delete(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(uploadFileService.removeById(id));
     }

     /**
      * 文件信息修改
      * @param uploadFile 文件信息
      * @return Result
      */
     @ApiOperation(value = "文件信息修改", notes = "文件信息修改")
     @PreAuthorize("hasAuthority('uploadFile:update')")
     @PutMapping
     public Result update(UploadFile uploadFile) {
          return ResultGenerator.genSuccessResult(uploadFileService.updateById(uploadFile));
     }

     /**
      * 文件信息详情
      * @param id 文件信息主键
      * @return Result
      */
     @ApiOperation(value = "文件信息详情", notes = "文件信息详情")
     @PreAuthorize("hasAuthority('uploadFile:view')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(uploadFileService.getById(id));
     }
}
