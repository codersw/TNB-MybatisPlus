package com.mango.demand.pool.service;

import com.mango.demand.pool.entity.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface IMenuService extends IService<Menu> {

    String findUserPermissions(Integer userId);
}
