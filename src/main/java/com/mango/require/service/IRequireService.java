package com.mango.require.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mango.require.model.CurrentUser;
import com.mango.require.model.Require;
import com.mango.require.model.RequireCo;

/**
 * <p>
 * 需求信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface IRequireService extends IService<Require> {

    void save(RequireCo requireCo, CurrentUser currentUser);

    void update(Require require, String[] fileIds);
}
