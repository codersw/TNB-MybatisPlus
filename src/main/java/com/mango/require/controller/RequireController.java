package com.mango.require.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mango.require.model.Require;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;
import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import com.mango.require.service.IRequireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;

/**
 * <p>
 * 需求信息 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Api(value = "需求信息接口", tags = {"需求信息接口"})
@Slf4j
@RestController
@RequestMapping("/require")
public class RequireController {

     @Resource
     private IRequireService requireService;

     /**
      * 需求信息列表
      * @param require 需求信息
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "需求信息列表", notes = "需求信息列表")
     @PreAuthorize("hasAuthority('require:view')")
     @GetMapping
     public Result list(Require require, PageRequest pageRequest, HttpServletRequest request) {
          Principal principal = request.getUserPrincipal();
          QueryWrapper<Require> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          Page<Require> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
          IPage<Require> requirePage = requireService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<Require>builder().list(requirePage.getRecords()).total(requirePage.getTotal()).build());
     }

     /**
      * 需求信息新增
      * @param require 需求信息
      * @return Result
      */
     @ApiOperation(value = "需求信息新增", notes = "需求信息新增")
     @PreAuthorize("hasAuthority('require:add')")
     @PostMapping
     public Result add(Require require, String fileIds) {
          requireService.save(require, fileIds.split(","));
          return ResultGenerator.genSuccessResult();
     }

     /**
      * 需求信息删除
      * @param ids 需求信息主键
      * @return Result
      */
     @ApiOperation(value = "需求信息删除", notes = "需求信息删除")
     @PreAuthorize("hasAuthority('require:delete')")
     @DeleteMapping("/{ids}")
     public Result delete(@PathVariable String ids) {
          return ResultGenerator.genSuccessResult(requireService.removeByIds(Arrays.asList(ids.split(StringPool.COMMA))));
     }

     /**
      * 需求信息修改
      * @param require 需求信息
      * @return Result
      */
     @ApiOperation(value = "需求信息修改", notes = "需求信息修改")
     @PreAuthorize("hasAuthority('require:update')")
     @PutMapping
     public Result update(Require require, String fileIds) {
          requireService.update(require, fileIds.split(","));
          return ResultGenerator.genSuccessResult();
     }

     /**
      * 需求信息详情
      * @param id 需求信息主键
      * @return Result
      */
     @ApiOperation(value = "需求信息详情", notes = "需求信息详情")
     @PreAuthorize("hasAuthority('require:view')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(requireService.getById(id));
     }
}
