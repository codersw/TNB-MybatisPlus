package com.mango.require.service.impl;

import com.mango.require.entity.pojo.RequireMerge;
import com.mango.require.mapper.RequireMergeMapper;
import com.mango.require.service.IRequireMergeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
