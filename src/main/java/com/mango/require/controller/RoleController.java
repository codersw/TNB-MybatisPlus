package com.mango.require.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
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
import com.mango.require.service.IRoleService;
import com.mango.require.model.Role;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import com.mango.require.model.common.PageResponse;
import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 * 角色信息 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Api(value = "角色信息接口", tags = {"角色信息接口"})
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

     @Resource
     private IRoleService roleService;

     /**
      * 角色信息列表
      * @param role 角色信息
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "角色信息列表", notes = "角色信息列表")
     @PreAuthorize("hasAuthority('role:view')")
     @GetMapping
     public Result list(Role role, PageRequest pageRequest) {
          QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          Page<Role> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
          IPage<Role> rolePage = roleService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<Role>builder().list(rolePage.getRecords()).total(rolePage.getTotal()).build());
     }

     /**
      * 角色信息新增
      * @param role 角色信息
      * @return Result
      */
     @ApiOperation(value = "角色信息新增", notes = "角色信息新增")
     @PreAuthorize("hasAuthority('role:add')")
     @PostMapping
     public Result add(Role role) {
          return ResultGenerator.genSuccessResult(roleService.save(role));
     }

     /**
      * 角色信息删除
      * @param ids 角色信息主键
      * @return Result
      */
     @ApiOperation(value = "角色信息删除", notes = "角色信息删除")
     @PreAuthorize("hasAuthority('role:delete')")
     @DeleteMapping("/{ids}")
     public Result delete(@PathVariable String ids) {
          return ResultGenerator.genSuccessResult(roleService.removeByIds(Arrays.asList(ids.split(StringPool.COMMA))));
     }

     /**
      * 角色信息修改
      * @param role 角色信息
      * @return Result
      */
     @ApiOperation(value = "角色信息修改", notes = "角色信息修改")
     @PreAuthorize("hasAuthority('role:update')")
     @PutMapping
     public Result update(Role role) {
          return ResultGenerator.genSuccessResult(roleService.updateById(role));
     }

     /**
      * 角色信息详情
      * @param id 角色信息主键
      * @return Result
      */
     @ApiOperation(value = "角色信息详情", notes = "角色信息详情")
     @PreAuthorize("hasAuthority('role:view')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(roleService.getById(id));
     }
}
