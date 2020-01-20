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
import com.mango.require.service.IRoleService;
import com.mango.require.model.Role;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import javax.annotation.Resource;

/**
 * <p>
 * 角色信息 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-19
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
        return ResultGenerator.genSuccessResult(roleService.roleList(role, pageRequest));
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
      * @param id 角色信息主键
      * @return Result
      */
     @ApiOperation(value = "角色信息删除", notes = "角色信息删除")
     @PreAuthorize("hasAuthority('role:delete')")
     @DeleteMapping("/{id: \\d+}")
     public Result delete(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(roleService.removeById(id));
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
