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
import com.mango.require.service.IMenuService;
import com.mango.require.model.Menu;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import javax.annotation.Resource;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
@Api(value = "菜单接口", tags = {"菜单接口"})
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {

     @Resource
     private IMenuService menuService;

     /**
      * 菜单列表
      * @param menu 菜单
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "菜单列表", notes = "菜单列表")
     @PreAuthorize("hasAuthority('menu:view')")
     @GetMapping
     public Result list(Menu menu, PageRequest pageRequest) {
        return ResultGenerator.genSuccessResult(menuService.menuList(menu, pageRequest));
     }

     /**
      * 菜单新增
      * @param menu 菜单
      * @return Result
      */
     @ApiOperation(value = "菜单新增", notes = "菜单新增")
     @PreAuthorize("hasAuthority('menu:add')")
     @PostMapping
     public Result add(Menu menu) {
        return ResultGenerator.genSuccessResult(menuService.save(menu));
     }

     /**
      * 菜单删除
      * @param id 菜单主键
      * @return Result
      */
     @ApiOperation(value = "菜单删除", notes = "菜单删除")
     @PreAuthorize("hasAuthority('menu:delete')")
     @DeleteMapping("/{id: \\d+}")
     public Result delete(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(menuService.removeById(id));
     }

     /**
      * 菜单修改
      * @param menu 菜单
      * @return Result
      */
     @ApiOperation(value = "菜单修改", notes = "菜单修改")
     @PreAuthorize("hasAuthority('menu:update')")
     @PutMapping
     public Result update(Menu menu) {
        return ResultGenerator.genSuccessResult(menuService.updateById(menu));
     }

     /**
      * 菜单详情
      * @param id 菜单主键
      * @return Result
      */
     @ApiOperation(value = "菜单详情", notes = "菜单详情")
     @PreAuthorize("hasAuthority('menu:view')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(menuService.getById(id));
     }
}
