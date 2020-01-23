package com.mango.require.service.impl;

import com.mango.require.mapper.UserRoleMapper;
import com.mango.require.entity.pojo.Role;
import com.mango.require.entity.pojo.User;
import com.mango.require.entity.pojo.UserRole;
import com.mango.require.mapper.UserMapper;
import com.mango.require.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public User findByUserName(String userName) {
        return this.baseMapper.findByUserName(userName);
    }

    @Override
    public void save(User user, List<Role> roles) {
        baseMapper.insert(user);
        roles.forEach(role -> this.userRoleMapper.insert(UserRole.builder()
                .roleId(role.getRoleId())
                .userId(user.getUserId())
                .build()));
    }
}
