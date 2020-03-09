package com.mango.demand.pool.service.impl;

import com.mango.demand.pool.entity.pojo.RequireTag;
import com.mango.demand.pool.mapper.RequireTagMapper;
import com.mango.demand.pool.service.IRequireTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 需求标签信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class RequireTagServiceImpl extends ServiceImpl<RequireTagMapper, RequireTag> implements IRequireTagService {

}
