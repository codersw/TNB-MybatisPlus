package com.mango.require.service.impl;

import com.mango.require.model.RoleMenu;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;
import com.mango.require.mapper.RoleMenuMapper;
import com.mango.require.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色菜单 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
