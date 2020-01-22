package com.mango.require.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.require.enums.IsDelEnum;
import com.mango.require.enums.PriorityEnum;
import com.mango.require.enums.RequireStatusEnum;
import com.mango.require.enums.UrgentEnum;
import com.mango.require.exception.RequireException;
import com.mango.require.mapper.RequireFileMapper;
import com.mango.require.mapper.RequireMapper;
import com.mango.require.model.CurrentUser;
import com.mango.require.model.Require;
import com.mango.require.model.RequireCo;
import com.mango.require.model.RequireFile;
import com.mango.require.service.IRequireService;
import com.mango.require.utils.MapperUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
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

    @Resource
    private RequireFileMapper requireFileMapper;

    @Override
    public void save(RequireCo requireCo, CurrentUser currentUser) {
        Require require = MapperUtils.mapperBean(requireCo, Require.class);
        require.setCreateTime(new Date());
        require.setCreateUserId(currentUser.getUserId());
        require.setModifyTime(new Date());
        require.setModifyUserId(currentUser.getUserId());
        require.setIsDel(IsDelEnum.FALSE.getValue());
        require.setStatus(RequireStatusEnum.INPLANNING.getValue());
        require.setUrgent(UrgentEnum.NOEMERGENT.getValue());
        require.setPriority(PriorityEnum.NOIMPORTANT.getValue());
        this.baseMapper.insert(require);
        if(StringUtils.isNotBlank(requireCo.getFileIds())) {
            String[] fileIds = requireCo.getFileIds().split(StringPool.COMMA);
            for(String fileId : fileIds) {
                this.requireFileMapper.insert(RequireFile.builder()
                        .fileId(Integer.valueOf(fileId))
                        .requireId(require.getRequireId())
                        .build());
            }
        }
    }

    @Override
    public void update(Require require, String[] fileIds) {
        QueryWrapper<Require> requireQueryWrapper = new QueryWrapper<>();
        requireQueryWrapper.lambda().eq(Require::getRequireId, require.getRequireId()).eq(Require::getIsDel, IsDelEnum.FALSE.getValue());
        if(CollectionUtils.isNotEmpty(this.baseMapper.selectList(requireQueryWrapper))) {
            this.baseMapper.updateById(require);
            requireFileMapper.deleteById(require.getRequireId());
            for(String fileId : fileIds) {
                this.requireFileMapper.insert(RequireFile.builder().fileId(Integer.valueOf(fileId)).requireId(require.getRequireId()).build());
            }
        } else {
            throw new RequireException("没有该需求信息");
        }
    }
}
