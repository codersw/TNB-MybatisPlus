package com.mango.require.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mango.require.entity.co.RequireListCo;
import com.mango.require.entity.co.RequireUpdateCo;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.common.PageResponse;
import com.mango.require.entity.pojo.Require;
import com.mango.require.entity.co.RequireAddCo;
import com.mango.require.entity.vo.RequireDetailVo;

/**
 * <p>
 * 需求信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface IRequireService extends IService<Require> {

    void save(RequireAddCo requireAddCo, CurrentUser currentUser);

    void update(RequireUpdateCo requireUpdateCo, CurrentUser currentUser);

    void merge(Integer masterId, String branchIds, CurrentUser currentUser);

    void tag(Integer requireId, String tagIds);

    void priority(Integer requireId, Integer priority, CurrentUser currentUser);

    void urgent(Integer requireId, Integer urgent, CurrentUser currentUser);

    void status(Integer requireId, Integer status, CurrentUser currentUser);

    PageResponse list(RequireListCo requireListCo);

    RequireDetailVo detail(Integer requireId);
}
