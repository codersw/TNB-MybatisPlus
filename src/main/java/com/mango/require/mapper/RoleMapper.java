package com.mango.require.mapper;

import com.mango.require.model.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色信息 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
public interface RoleMapper extends BaseMapper<Role> {


    List<Role> getRoles(Integer userId);
}
