package com.mango.require.service.impl;

import com.mango.require.entity.pojo.RequireTag;
import com.mango.require.mapper.RequireTagMapper;
import com.mango.require.service.IRequireTagService;
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
