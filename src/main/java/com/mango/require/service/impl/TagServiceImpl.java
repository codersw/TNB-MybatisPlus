package com.mango.require.service.impl;

import com.mango.require.entity.pojo.Tag;
import com.mango.require.mapper.TagMapper;
import com.mango.require.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 标签信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
