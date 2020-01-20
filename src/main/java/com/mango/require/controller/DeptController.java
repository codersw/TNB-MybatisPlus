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
import com.mango.require.service.IDeptService;
import com.mango.require.model.Dept;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import com.mango.require.model.common.PageResponse;
import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Api(value = "接口", tags = {"接口"})
@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {

     @Resource
     private IDeptService deptService;

     /**
      * 列表
      * @param dept 
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "列表", notes = "列表")
     @PreAuthorize("hasAuthority('dept:view')")
     @GetMapping
     public Result list(Dept dept, PageRequest pageRequest) {
          QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          Page<Dept> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
          IPage<Dept> deptPage = deptService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<Dept>builder().list(deptPage.getRecords()).total(deptPage.getTotal()).build());
     }

     /**
      * 新增
      * @param dept 
      * @return Result
      */
     @ApiOperation(value = "新增", notes = "新增")
     @PreAuthorize("hasAuthority('dept:add')")
     @PostMapping
     public Result add(Dept dept) {
          return ResultGenerator.genSuccessResult(deptService.save(dept));
     }

     /**
      * 删除
      * @param id 主键
      * @return Result
      */
     @ApiOperation(value = "删除", notes = "删除")
     @PreAuthorize("hasAuthority('dept:delete')")
     @DeleteMapping("/{id: \\d+}")
     public Result delete(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(deptService.removeById(id));
     }

     /**
      * 修改
      * @param dept 
      * @return Result
      */
     @ApiOperation(value = "修改", notes = "修改")
     @PreAuthorize("hasAuthority('dept:update')")
     @PutMapping
     public Result update(Dept dept) {
          return ResultGenerator.genSuccessResult(deptService.updateById(dept));
     }

     /**
      * 详情
      * @param id 主键
      * @return Result
      */
     @ApiOperation(value = "详情", notes = "详情")
     @PreAuthorize("hasAuthority('dept:view')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(deptService.getById(id));
     }
}
