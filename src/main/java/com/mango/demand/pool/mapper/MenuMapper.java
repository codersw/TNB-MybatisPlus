package com.mango.demand.pool.mapper;

import com.mango.demand.pool.entity.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenus(@Param("userId") Integer userId);
}
