package com.mango.require.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import com.mango.require.service.IRequireCommentService;
import com.mango.require.entity.pojo.RequireComment;
import com.mango.require.entity.common.PageRequest;
import com.mango.require.entity.common.Result;
import com.mango.require.entity.common.ResultGenerator;
import com.mango.require.entity.common.PageResponse;
import javax.annotation.Resource;
import java.util.Arrays;
/**
 * <p>
 * 需求评论 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-22
 */
@Api(value = "需求评论接口", tags = {"需求评论接口"})
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

     @Resource
     private IRequireCommentService requireCommentService;

     /**
      * 需求评论列表
      * @param requireComment 需求评论
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "需求评论列表", notes = "需求评论列表")
     @PreAuthorize("hasAuthority('comment:view')")
     @GetMapping
     public Result list(RequireComment requireComment, PageRequest pageRequest) {
          QueryWrapper<RequireComment> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          Page<RequireComment> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
          IPage<RequireComment> requireCommentPage = requireCommentService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<RequireComment>builder().list(requireCommentPage.getRecords()).total(requireCommentPage.getTotal()).build());
     }

     /**
      * 需求评论新增
      * @param requireComment 需求评论
      * @return Result
      */
     @ApiOperation(value = "需求评论新增", notes = "需求评论新增")
     @PreAuthorize("hasAuthority('comment:add')")
     @PostMapping
     public Result add(RequireComment requireComment) {
          return ResultGenerator.genSuccessResult(requireCommentService.save(requireComment));
     }

     /**
      * 需求评论删除
      * @param ids 需求评论主键
      * @return Result
      */
     @ApiOperation(value = "需求评论删除", notes = "需求评论删除")
     @PreAuthorize("hasAuthority('comment:delete')")
     @DeleteMapping("/{ids}")
     public Result delete(@PathVariable String ids) {
          return ResultGenerator.genSuccessResult(requireCommentService.removeByIds(Arrays.asList(ids.split(StringPool.COMMA))));
     }

     /**
      * 需求评论修改
      * @param requireComment 需求评论
      * @return Result
      */
     @ApiOperation(value = "需求评论修改", notes = "需求评论修改")
     @PreAuthorize("hasAuthority('comment:update')")
     @PutMapping
     public Result update(RequireComment requireComment) {
          return ResultGenerator.genSuccessResult(requireCommentService.updateById(requireComment));
     }

     /**
      * 需求评论详情
      * @param id 需求评论主键
      * @return Result
      */
     @ApiOperation(value = "需求评论详情", notes = "需求评论详情")
     @PreAuthorize("hasAuthority('comment:view')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(requireCommentService.getById(id));
     }
}
