package com.mango.demand.pool.service.impl;

import com.mango.demand.pool.entity.pojo.RequireFile;
import com.mango.demand.pool.mapper.RequireFileMapper;
import com.mango.demand.pool.service.IRequireFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 需求附件信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class RequireFileServiceImpl extends ServiceImpl<RequireFileMapper, RequireFile> implements IRequireFileService {

}
