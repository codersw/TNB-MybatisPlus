package com.mango.require.service.impl;

import com.mango.require.model.Menu;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;
import com.mango.require.mapper.MenuMapper;
import com.mango.require.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
