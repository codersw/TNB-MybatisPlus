package com.mango.require.service.impl;

import com.mango.require.entity.pojo.RequireComment;
import com.mango.require.mapper.RequireCommentMapper;
import com.mango.require.service.IRequireCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 需求评论 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class RequireCommentServiceImpl extends ServiceImpl<RequireCommentMapper, RequireComment> implements IRequireCommentService {

}
