package com.mango.require.service;

import com.mango.require.model.Require;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 需求信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface IRequireService extends IService<Require> {

    void save(Require require, String[] fileIds);

    void update(Require require, String[] fileIds);
}
