package com.mango.require.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mango.require.entity.co.RequireListCo;
import com.mango.require.entity.pojo.Require;
import com.mango.require.entity.vo.RequireVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 需求信息 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface RequireMapper extends BaseMapper<Require> {

    IPage<RequireVo> selectList(Page<RequireVo> page, @Param(Constants.WRAPPER) Wrapper<RequireListCo> wrapper);
}
