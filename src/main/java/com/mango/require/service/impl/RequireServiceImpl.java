package com.mango.require.service.impl;

import com.mango.require.model.Require;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;
import com.mango.require.mapper.RequireMapper;
import com.mango.require.service.IRequireService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 需求信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class RequireServiceImpl extends ServiceImpl<RequireMapper, Require> implements IRequireService {

}
