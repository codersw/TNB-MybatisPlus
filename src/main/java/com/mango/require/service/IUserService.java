package com.mango.require.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.pojo.Role;
import com.mango.require.entity.pojo.User;

import java.util.List;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface IUserService extends IService<User> {

    CurrentUser findByUserId(Integer userId);

    User findByUserName(String userName);

    void save(User user, List<Role> roles);
}
