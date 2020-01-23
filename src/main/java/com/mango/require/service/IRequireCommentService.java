package com.mango.require.service;

import com.mango.require.entity.co.RequireCommentAddCo;
import com.mango.require.entity.co.RequireCommentListCo;
import com.mango.require.entity.co.RequireCommentUpdateCo;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.common.PageResponse;
import com.mango.require.entity.pojo.RequireComment;
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
