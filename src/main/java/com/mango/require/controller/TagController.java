package com.mango.require.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mango.require.entity.co.TagAddCo;
import com.mango.require.entity.co.TagListCo;
import com.mango.require.entity.co.TagUpdateCo;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.common.PageResponse;
import com.mango.require.entity.common.Result;
import com.mango.require.entity.common.ResultGenerator;
import com.mango.require.entity.pojo.Tag;
import com.mango.require.service.ITagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 * 标签信息 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Api(value = "标签信息接口", tags = {"标签信息接口"})
@Slf4j
@RestController
@RequestMapping("/tag")
public class TagController {

     @Resource
     private ITagService tagService;

     /**
      * 标签信息列表
      * @param tagListCo 标签列表查询信息
      * @return Result
      */
     @ApiOperation(value = "标签信息列表", notes = "标签信息列表")
     @PreAuthorize("hasAuthority('tag:view')")
     @GetMapping
     public Result list(TagListCo tagListCo) {
          QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
          if(StringUtils.isNotEmpty(tagListCo.getKeyword())) {
              queryWrapper.lambda().like(Tag::getTagName, tagListCo.getKeyword()).like(Tag::getTagDesc, tagListCo.getKeyword());
          }
          Page<Tag> page = new Page<>(tagListCo.getPageIndex(), tagListCo.getPageSize());
          IPage<Tag> tagPage = tagService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<Tag>builder().list(tagPage.getRecords()).total(tagPage.getTotal()).build());
     }

     /**
      * 标签信息新增
      * @param tagAddCo 标签新增信息
      * @param currentUser 当前登陆人
      * @return Result
      */
     @ApiOperation(value = "标签信息新增", notes = "标签信息新增")
     @PreAuthorize("hasAuthority('tag:add')")
     @PostMapping
     public Result add(TagAddCo tagAddCo, @ApiIgnore CurrentUser currentUser) {
          tagService.save(tagAddCo, currentUser);
          return ResultGenerator.genSuccessResult();
     }

     /**
      * 标签信息删除
      * @param ids 标签信息主键
      * @return Result
      */
     @ApiOperation(value = "标签信息删除", notes = "标签信息删除")
     @PreAuthorize("hasAuthority('tag:delete')")
     @DeleteMapping("/{ids}")
     public Result delete(@PathVariable String ids) {
          return ResultGenerator.genSuccessResult(tagService.removeByIds(Arrays.asList(ids.split(StringPool.COMMA))));
     }

     /**
      * 标签信息修改
      * @param tagUpdateCo 标签修改信息
      * @param currentUser 当前登陆人
      * @return Result
      */
     @ApiOperation(value = "标签信息修改", notes = "标签信息修改")
     @PreAuthorize("hasAuthority('tag:update')")
     @PutMapping
     public Result update(TagUpdateCo tagUpdateCo, @ApiIgnore CurrentUser currentUser) {
          tagService.update(tagUpdateCo, currentUser);
          return ResultGenerator.genSuccessResult();
     }

     /**
      * 标签信息详情
      * @param id 标签信息主键
      * @return Result
      */
     @ApiOperation(value = "标签信息详情", notes = "标签信息详情")
     @PreAuthorize("hasAuthority('tag:view')")
     @GetMapping("/{id:\\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(tagService.getById(id));
     }
}
