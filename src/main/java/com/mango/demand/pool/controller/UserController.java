package com.mango.demand.pool.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mango.demand.pool.entity.common.*;
import com.mango.demand.pool.entity.pojo.User;
import com.mango.require.entity.common.*;
import com.mango.demand.pool.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

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
          CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext()
                  .getAuthentication()
                  .getDetails();
          log.info("{}", JSONObject.toJSONString(currentUser));
          QueryWrapper<User> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件
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
     public Result add(@RequestBody User user) {
          return ResultGenerator.genSuccessResult(userService.save(user));
     }

     /**
      * 用户信息删除
      * @param ids 用户信息主键
      * @return Result
      */
     @ApiOperation(value = "用户信息删除", notes = "用户信息删除")
     @PreAuthorize("hasAuthority('user:delete')")
     @DeleteMapping("/{ids}")
     public Result delete(@PathVariable String ids) {
          return ResultGenerator.genSuccessResult(userService.removeByIds(Arrays.asList(ids.split(StringPool.COMMA))));
     }

     /**
      * 用户信息修改
      * @param user 用户信息
      * @return Result
      */
     @ApiOperation(value = "用户信息修改", notes = "用户信息修改")
     @PreAuthorize("hasAuthority('user:update')")
     @PutMapping
     public Result update(@RequestBody User user) {
          return ResultGenerator.genSuccessResult(userService.updateById(user));
     }

     /**
      * 用户信息详情
      * @param id 用户信息主键
      * @return Result
      */
     @ApiOperation(value = "用户信息详情", notes = "用户信息详情")
     @PreAuthorize("hasAuthority('user:view')")
     @GetMapping("/{id:\\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(userService.getById(id));
     }
}
