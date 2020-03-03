package com.mango.require.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.require.entity.co.TagAddCo;
import com.mango.require.entity.co.TagUpdateCo;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.pojo.Tag;
import com.mango.require.enums.IsDelEnum;
import com.mango.require.mapper.TagMapper;
import com.mango.require.service.ITagService;
import com.mango.require.utils.MapperUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public String save(TagAddCo tagAddCo, CurrentUser currentUser) {
        List<String> list = new ArrayList<>();
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
                    list.add(tagName);
                }
            }
        }
        return CollectionUtils.isNotEmpty(list) ? StringUtils.join(list, StringPool.COMMA) + "等标签名称已被使用不可以重复添加" : "";
    }

    @Override
    public void update(TagUpdateCo tagUpdateCo, CurrentUser currentUser) {
        Tag tag = MapperUtils.mapperBean(tagUpdateCo, Tag.class);
        tag.setModifyTime(new Date());
        tag.setModifyUserId(currentUser.getUserId());
        baseMapper.updateById(tag);
    }
}
