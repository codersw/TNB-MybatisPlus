package com.mango.require.service.impl;

import com.mango.require.model.User;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;
import com.mango.require.mapper.UserMapper;
import com.mango.require.service.IUserService;
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
 * 用户信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

     @Override
     public PageResponse<User> userList(User user, PageRequest pageRequest) {
          QueryWrapper<User> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //返回值
          PageResponse<User> response = PageResponse.<User>builder().build();
          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          //分页
          if(pageRequest.getPaging()) {
               Page<User> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
               IPage<User> userPage = this.baseMapper.selectPage(page, queryWrapper);
               response.setList(userPage.getRecords());
               response.setTotal(userPage.getTotal());
          } else {
               List<User> userList = this.baseMapper.selectList(queryWrapper);
               response.setList(userList);
               response.setTotal((long) userList.size());
          }
          return response;
     }
 }
