package com.mango.require.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.require.enums.IsDelEnum;
import com.mango.require.exception.RequireException;
import com.mango.require.mapper.RequireFileMapper;
import com.mango.require.mapper.RequireMapper;
import com.mango.require.model.Require;
import com.mango.require.model.RequireFile;
import com.mango.require.service.IRequireService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
    public void save(Require require, String[] fileIds) {
        this.baseMapper.insert(require);
        for(String fileId : fileIds) {
            this.requireFileMapper.insert(RequireFile.builder().fileId(Integer.valueOf(fileId)).requireId(require.getRequireId()).build());
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
