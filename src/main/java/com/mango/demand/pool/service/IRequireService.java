package com.mango.demand.pool.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mango.demand.pool.entity.co.RequireAdminListCo;
import com.mango.demand.pool.entity.co.RequireListCo;
import com.mango.demand.pool.entity.co.RequireUpdateCo;
import com.mango.demand.pool.entity.common.CurrentUser;
import com.mango.demand.pool.entity.common.PageResponse;
import com.mango.demand.pool.entity.pojo.Require;
import com.mango.demand.pool.entity.co.RequireAddCo;
import com.mango.demand.pool.entity.vo.RequireDetailVo;

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

    PageResponse adminList(RequireAdminListCo requireAdminListCo);

    PageResponse list(RequireListCo requireListCo);

    RequireDetailVo detail(Integer requireId);
}
