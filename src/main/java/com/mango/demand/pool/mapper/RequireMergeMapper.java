package com.mango.demand.pool.mapper;

import com.mango.demand.pool.entity.pojo.RequireMerge;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mango.demand.pool.entity.vo.RequireMergeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 需求合并 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-01-23
 */
public interface RequireMergeMapper extends BaseMapper<RequireMerge> {

    List<RequireMergeVo> selectBranchs(@Param("requireId") Integer requireId);

    RequireMergeVo selectMaster(@Param("requireId") Integer requireId);
}
