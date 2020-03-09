package com.mango.demand.pool.service;

import com.mango.demand.pool.entity.common.CurrentUser;
import com.mango.demand.pool.entity.common.PageResponse;
import com.mango.demand.pool.entity.pojo.RequireComment;
import com.mango.demand.pool.entity.co.RequireCommentAddCo;
import com.mango.demand.pool.entity.co.RequireCommentListCo;
import com.mango.demand.pool.entity.co.RequireCommentUpdateCo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 需求评论 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-22
 */
public interface IRequireCommentService extends IService<RequireComment> {

    PageResponse list(RequireCommentListCo requireCommentListCo);

    void save(RequireCommentAddCo requireCommentAddCo, CurrentUser currentUser);

    void update(RequireCommentUpdateCo requireCommentUpdateCo, CurrentUser currentUser);

}
