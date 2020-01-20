package com.mango.require.service.impl;

import com.mango.require.model.Role;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;
import com.mango.require.mapper.RoleMapper;
import com.mango.require.service.IRoleService;
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
 * 角色信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

     @Override
     public PageResponse<Role> roleList(Role role, PageRequest pageRequest) {
          QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //返回值
          PageResponse<Role> response = PageResponse.<Role>builder().build();
          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          //分页
          if(pageRequest.getPaging()) {
               Page<Role> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
               IPage<Role> userPage = this.baseMapper.selectPage(page, queryWrapper);
               response.setList(userPage.getRecords());
               response.setTotal(userPage.getTotal());
          } else {
               List<Role> userList = this.baseMapper.selectList(queryWrapper);
               response.setList(userList);
               response.setTotal((long) userList.size());
          }
          return response;
     }
 }
