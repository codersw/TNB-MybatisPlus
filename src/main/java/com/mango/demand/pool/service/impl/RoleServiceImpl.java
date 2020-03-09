package com.mango.demand.pool.service.impl;

import com.mango.demand.pool.mapper.RoleMapper;
import com.mango.demand.pool.entity.pojo.Role;
import com.mango.demand.pool.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
