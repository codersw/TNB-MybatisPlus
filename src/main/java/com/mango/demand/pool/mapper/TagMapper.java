package com.mango.demand.pool.mapper;

import com.mango.demand.pool.entity.pojo.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 标签信息 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> selectByRequireId(Integer requireId);
}
