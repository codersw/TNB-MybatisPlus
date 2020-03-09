package com.mango.demand.pool.service.impl;

import com.mango.demand.pool.entity.pojo.RequireMerge;
import com.mango.demand.pool.mapper.RequireMergeMapper;
import com.mango.demand.pool.service.IRequireMergeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 需求合并 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-23
 */
@Service
@Transactional
public class RequireMergeServiceImpl extends ServiceImpl<RequireMergeMapper, RequireMerge> implements IRequireMergeService {

}
