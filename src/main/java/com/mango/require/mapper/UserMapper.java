package com.mango.require.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mango.require.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
public interface UserMapper extends BaseMapper<User> {

    User findByUserName(@Param("username") String username);
}
