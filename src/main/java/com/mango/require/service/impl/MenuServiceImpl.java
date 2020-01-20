package com.mango.require.service.impl;

import com.mango.require.model.Menu;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;
import com.mango.require.mapper.MenuMapper;
import com.mango.require.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
@Service
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

     @Override
     public PageResponse<Menu> menuList(Menu menu, PageRequest pageRequest) {
          QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //返回值
          PageResponse<Menu> response = PageResponse.<Menu>builder().build();
          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          //分页
          if(pageRequest.getPaging()) {
               Page<Menu> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
               IPage<Menu> userPage = this.baseMapper.selectPage(page, queryWrapper);
               response.setList(userPage.getRecords());
               response.setTotal(userPage.getTotal());
          } else {
               List<Menu> userList = this.baseMapper.selectList(queryWrapper);
               response.setList(userList);
               response.setTotal((long) userList.size());
          }
          return response;
     }
 }
