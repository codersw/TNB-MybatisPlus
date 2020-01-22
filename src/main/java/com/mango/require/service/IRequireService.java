package com.mango.require.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.pojo.Require;
import com.mango.require.entity.co.RequireAddCo;

/**
 * <p>
 * 需求信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface IRequireService extends IService<Require> {

    void save(RequireAddCo requireCo, CurrentUser currentUser);

    void update(Require require, String[] fileIds);
}
