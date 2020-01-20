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
import com.mango.require.service.IUserService;
import com.mango.require.model.User;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import com.mango.require.model.common.PageResponse;
import javax.annotation.Resource;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Api(value = "用户信息接口", tags = {"用户信息接口"})
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

     @Resource
     private IUserService userService;

     /**
      * 用户信息列表
      * @param user 用户信息
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "用户信息列表", notes = "用户信息列表")
     @PreAuthorize("hasAuthority('user:view')")
     @GetMapping
     public Result list(User user, PageRequest pageRequest) {
          QueryWrapper<User> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          Page<User> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
          IPage<User> userPage = userService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<User>builder().list(userPage.getRecords()).total(userPage.getTotal()).build());
     }

     /**
      * 用户信息新增
      * @param user 用户信息
      * @return Result
      */
     @ApiOperation(value = "用户信息新增", notes = "用户信息新增")
     @PreAuthorize("hasAuthority('user:add')")
     @PostMapping
     public Result add(User user) {
          return ResultGenerator.genSuccessResult(userService.save(user));
     }

     /**
      * 用户信息删除
      * @param id 用户信息主键
      * @return Result
      */
     @ApiOperation(value = "用户信息删除", notes = "用户信息删除")
     @PreAuthorize("hasAuthority('user:delete')")
     @DeleteMapping("/{id: \\d+}")
     public Result delete(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(userService.removeById(id));
     }

     /**
      * 用户信息修改
      * @param user 用户信息
      * @return Result
      */
     @ApiOperation(value = "用户信息修改", notes = "用户信息修改")
     @PreAuthorize("hasAuthority('user:update')")
     @PutMapping
     public Result update(User user) {
          return ResultGenerator.genSuccessResult(userService.updateById(user));
     }

     /**
      * 用户信息详情
      * @param id 用户信息主键
      * @return Result
      */
     @ApiOperation(value = "用户信息详情", notes = "用户信息详情")
     @PreAuthorize("hasAuthority('user:view')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(userService.getById(id));
     }
}
