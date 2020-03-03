package com.mango.require.service;

import com.mango.require.entity.co.TagAddCo;
import com.mango.require.entity.co.TagUpdateCo;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.pojo.Tag;
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

    String save(TagAddCo tagAddCo, CurrentUser currentUser);

    void update(TagUpdateCo tagUpdateCo, CurrentUser currentUser);
}
