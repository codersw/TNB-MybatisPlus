package com.mango.require.service;

import com.mango.require.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-17
 */
public interface IUserService extends IService<User> {

     PageResponse<User> userList(User user, PageRequest pageRequest);
}
