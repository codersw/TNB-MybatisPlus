package com.mango.demand.pool.mapper;

import com.mango.demand.pool.entity.pojo.UploadFile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 文件信息 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface UploadFileMapper extends BaseMapper<UploadFile> {

    List<UploadFile> selectByRequireId(@Param("requireId") Integer requireId);
}
