package com.mango.require.service;

import com.mango.require.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;

/**
 * <p>
 * 角色信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
public interface IRoleService extends IService<Role> {

     PageResponse<Role> roleList(Role role, PageRequest pageRequest);
}
