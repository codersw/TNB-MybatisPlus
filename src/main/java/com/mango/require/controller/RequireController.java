package com.mango.require.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.mango.require.entity.co.RequireListCo;
import com.mango.require.entity.co.RequireUpdateCo;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.co.RequireAddCo;
import com.mango.require.entity.common.Result;
import com.mango.require.entity.common.ResultGenerator;
import com.mango.require.enums.RequireHandleTypeEnum;
import com.mango.require.service.IRequireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Objects;

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
      * @param requireListCo 需求列表查询信息
      * @return Result
      */
     @ApiOperation(value = "需求信息列表", notes = "需求信息列表")
     @PreAuthorize("hasAuthority('require:view')")
     @GetMapping
     public Result list(RequireListCo requireListCo) {
          return ResultGenerator.genSuccessResult(requireService.list(requireListCo));
     }

     /**
      * 需求信息新增
      * @param requireAddCo 需求新增信息
      * @param currentUser 当前登陆人
      * @return Result
      */
     @ApiOperation(value = "需求信息新增", notes = "需求信息新增")
     @PreAuthorize("hasAuthority('require:add')")
     @PostMapping
     public Result add(RequireAddCo requireAddCo, @ApiIgnore CurrentUser currentUser) {
          requireService.save(requireAddCo, currentUser);
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
      * @param requireUpdateCo 需求新增信息
      * @param currentUser 当前登陆人
      * @return Result
      */
     @ApiOperation(value = "需求信息修改", notes = "需求信息修改")
     @PreAuthorize("hasAuthority('require:update')")
     @PutMapping
     public Result update(RequireUpdateCo requireUpdateCo, @ApiIgnore CurrentUser currentUser) {
          requireService.update(requireUpdateCo, currentUser);
          return ResultGenerator.genSuccessResult();
     }

     /**
      * 需求信息合并
      * @param type 操作类型
      * @param requireId 需求id
      * @param param 参数
      * @return Result
      */
     @ApiOperation(value = "需求信息操作", notes = "需求信息操作")
     @PreAuthorize("hasAuthority('require:update')")
     @GetMapping("/{type}/{requireId:\\d+}/{param}")
     public Result handle(@ApiParam("操作类型") @PathVariable @RequestParam String type, @ApiParam("主需求id") @PathVariable @RequestParam Integer requireId,
                          @ApiParam(value = "参数") @RequestParam @PathVariable String param) {
          if(type.equals(RequireHandleTypeEnum.MERGE.getValue())) {
               requireService.merge(requireId, param);
          } else if(type.equals(RequireHandleTypeEnum.TAG.getValue())) {
               requireService.tag(requireId, param);
          } else if(type.equals(RequireHandleTypeEnum.PRIORITY.getValue())) {
               requireService.priority(requireId, Integer.valueOf(param));
          } else if(type.equals(RequireHandleTypeEnum.URGENT.getValue())) {
               requireService.urgent(requireId, Integer.valueOf(param));
          } else if(type.equals(RequireHandleTypeEnum.STATUS.getValue())) {
               requireService.status(requireId, Integer.valueOf(param));
          }
          return ResultGenerator.genSuccessResult();
     }

     /**
      * 需求信息详情
      * @param id 需求信息主键
      * @return Result
      */
     @ApiOperation(value = "需求信息详情", notes = "需求信息详情")
     @PreAuthorize("hasAuthority('require:view')")
     @GetMapping("/{id:\\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(requireService.getById(id));
     }
}
