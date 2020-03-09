package com.mango.demand.pool.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mango.demand.pool.entity.pojo.RequireComment;
import com.mango.demand.pool.entity.vo.RequireCommentVo;
import com.mango.demand.pool.entity.co.RequireCommentListCo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 需求评论 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-01-22
 */
public interface RequireCommentMapper extends BaseMapper<RequireComment> {

    IPage<RequireCommentVo> selectList(Page<RequireCommentVo> page, @Param("requireCommentListCo") RequireCommentListCo requireCommentListCo);
}
