package com.mango.require.controller;

import com.mango.require.entity.co.RequireCommentAddCo;
import com.mango.require.entity.co.RequireCommentListCo;
import com.mango.require.entity.co.RequireCommentUpdateCo;
import com.mango.require.entity.common.*;
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
import springfox.documentation.annotations.ApiIgnore;

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
      * @param requireCommentListCo 评论列表信息
      * @return Result
      */
     @ApiOperation(value = "需求评论列表", notes = "需求评论列表")
     @PreAuthorize("hasAuthority('comment:view')")
     @GetMapping
     public Result list(RequireCommentListCo requireCommentListCo) {
          QueryWrapper<RequireComment> queryWrapper = new QueryWrapper<>();
          queryWrapper.lambda().eq(RequireComment::getRequireId, requireCommentListCo.getRequireId());
          Page<RequireComment> page = new Page<>(requireCommentListCo.getPageIndex(), requireCommentListCo.getPageSize());
          IPage<RequireComment> requireCommentPage = requireCommentService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<RequireComment>builder().list(requireCommentPage.getRecords()).total(requireCommentPage.getTotal()).build());
     }

     /**
      * 需求评论新增
      * @param requireCommentAddCo 新增评论
      * @param currentUser 当前登陆人
      * @return Result
      */
     @ApiOperation(value = "需求评论新增", notes = "需求评论新增")
     @PreAuthorize("hasAuthority('comment:add')")
     @PostMapping
     public Result add(RequireCommentAddCo requireCommentAddCo, @ApiIgnore CurrentUser currentUser) {
          requireCommentService.save(requireCommentAddCo, currentUser);
          return ResultGenerator.genSuccessResult();
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
      * @param requireCommentUpdateCo 修改评论
      * @return Result
      */
     @ApiOperation(value = "需求评论修改", notes = "需求评论修改")
     @PreAuthorize("hasAuthority('comment:update')")
     @PutMapping
     public Result update(RequireCommentUpdateCo requireCommentUpdateCo, @ApiIgnore CurrentUser currentUser) {
          requireCommentService.update(requireCommentUpdateCo, currentUser);
          return ResultGenerator.genSuccessResult();
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
