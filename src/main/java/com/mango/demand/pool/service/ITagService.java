package com.mango.demand.pool.service;

import com.mango.demand.pool.entity.common.CurrentUser;
import com.mango.demand.pool.entity.pojo.Tag;
import com.mango.demand.pool.entity.co.TagAddCo;
import com.mango.demand.pool.entity.co.TagUpdateCo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 标签信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface ITagService extends IService<Tag> {

    void save(TagAddCo tagAddCo, CurrentUser currentUser);

    void update(TagUpdateCo tagUpdateCo, CurrentUser currentUser);
}
