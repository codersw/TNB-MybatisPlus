package com.mango.require.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mango.require.entity.common.*;
import com.mango.require.entity.pojo.UploadFile;
import com.mango.require.service.IUploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Arrays;

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
@RequestMapping("/upload")
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
     @PreAuthorize("hasAuthority('upload:view')")
     @GetMapping
     public Result list(UploadFile uploadFile, PageRequest pageRequest) {
          QueryWrapper<UploadFile> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件
          Page<UploadFile> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
          IPage<UploadFile> uploadFilePage = uploadFileService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<UploadFile>builder().list(uploadFilePage.getRecords()).total(uploadFilePage.getTotal()).build());
     }

     /**
      * 文件信息新增
      * @param file 文件
      * @param currentUser 当前登录人
      * @return Result
      */
     @ApiOperation(value = "文件信息新增", notes = "文件信息新增")
     @PreAuthorize("hasAuthority('upload:add')")
     @PostMapping(headers = "content-type=multipart/form-data")
     public Result add(@ApiParam(value = "文件", required = true) @RequestParam MultipartFile file, @ApiIgnore CurrentUser currentUser) throws Exception {
          return ResultGenerator.genSuccessResult(uploadFileService.save(file, currentUser));
     }

     /**
      * 文件信息删除
      * @param ids 文件信息主键
      * @return Result
      */
     @ApiOperation(value = "文件信息删除", notes = "文件信息删除")
     @PreAuthorize("hasAuthority('upload:delete')")
     @DeleteMapping("/{ids}")
     public Result delete(@PathVariable String ids) {
          return ResultGenerator.genSuccessResult(uploadFileService.removeByIds(Arrays.asList(ids.split(StringPool.COMMA))));
     }

     /**
      * 文件信息详情
      * @param id 文件信息主键
      * @return Result
      */
     @ApiOperation(value = "文件信息详情", notes = "文件信息详情")
     @PreAuthorize("hasAuthority('upload:view')")
     @GetMapping("/{id:\\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(uploadFileService.getById(id));
     }
}
