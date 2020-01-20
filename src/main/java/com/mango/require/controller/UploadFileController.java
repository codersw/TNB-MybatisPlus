package com.mango.require.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
import javax.annotation.Resource;

/**
 * <p>
 * 文件信息 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-19
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
        return ResultGenerator.genSuccessResult(uploadFileService.uploadFileList(uploadFile, pageRequest));
     }

     /**
      * 文件信息新增
      * @param uploadFile 文件信息
      * @return Result
      */
     @ApiOperation(value = "文件信息新增", notes = "文件信息新增")
     @PreAuthorize("hasAuthority('upload:add')")
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
     @PreAuthorize("hasAuthority('upload:delete')")
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
     @PreAuthorize("hasAuthority('upload:update')")
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
     @PreAuthorize("hasAuthority('upload:view')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(uploadFileService.getById(id));
     }
}
