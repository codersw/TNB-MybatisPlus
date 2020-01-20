package com.mango.require.service;

import com.mango.require.model.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
public interface IMenuService extends IService<Menu> {

     PageResponse<Menu> menuList(Menu menu, PageRequest pageRequest);
}
