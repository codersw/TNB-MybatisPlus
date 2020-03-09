package com.mango.demand.pool.mapper;

import com.mango.demand.pool.entity.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色信息 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoles(@Param("userId") Integer userId);
}
