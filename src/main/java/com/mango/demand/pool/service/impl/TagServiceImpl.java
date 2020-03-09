package com.mango.demand.pool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.demand.pool.entity.common.CurrentUser;
import com.mango.demand.pool.enums.IsDelEnum;
import com.mango.demand.pool.exception.RequireException;
import com.mango.demand.pool.utils.MapperUtils;
import com.mango.demand.pool.entity.co.TagAddCo;
import com.mango.demand.pool.entity.co.TagUpdateCo;
import com.mango.demand.pool.entity.pojo.Tag;
import com.mango.demand.pool.mapper.TagMapper;
import com.mango.demand.pool.service.ITagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    @Override
    public void save(TagAddCo tagAddCo, CurrentUser currentUser) {
        if(StringUtils.isNotEmpty(tagAddCo.getTagNames())) {
            String[] tagNames = tagAddCo.getTagNames().split(StringPool.COMMA);
            for(String tagName : tagNames) {
                QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
                queryWrapper.lambda().eq(Tag::getTagName, tagName);
                if(baseMapper.selectCount(queryWrapper).equals(0)) {
                    baseMapper.insert(Tag.builder()
                            .createTime(new Date())
                            .createUserId(currentUser.getUserId())
                            .modifyTime(new Date())
                            .modifyUserId(currentUser.getUserId())
                            .isDel(IsDelEnum.FALSE.getValue())
                            .tagName(tagName)
                            .tagDesc(tagAddCo.getTagDesc())
                            .build());
                } else {
                   throw new RequireException("标签名称" + tagName + "已被使用不可以重复添加");
                }
            }
        }
    }

    @Override
    public void update(TagUpdateCo tagUpdateCo, CurrentUser currentUser) {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Tag::getTagName, tagUpdateCo.getTagName())
                .ne(Tag::getTagId, tagUpdateCo.getTagId());
        if(baseMapper.selectCount(queryWrapper).equals(0)) {
            Tag tag = MapperUtils.mapperBean(tagUpdateCo, Tag.class);
            tag.setModifyTime(new Date());
            tag.setModifyUserId(currentUser.getUserId());
            baseMapper.updateById(tag);
        } else {
            throw new RequireException("标签名称" + tagUpdateCo.getTagName() + "已被使用不可以重复添加");
        }
    }
}
