package com.mango.require.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.require.entity.co.RequireListCo;
import com.mango.require.entity.co.RequireUpdateCo;
import com.mango.require.entity.common.PageResponse;
import com.mango.require.entity.vo.RequireVo;
import com.mango.require.enums.IsDelEnum;
import com.mango.require.enums.PriorityEnum;
import com.mango.require.enums.RequireStatusEnum;
import com.mango.require.enums.UrgentEnum;
import com.mango.require.exception.RequireException;
import com.mango.require.mapper.RequireFileMapper;
import com.mango.require.mapper.RequireMapper;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.pojo.Require;
import com.mango.require.entity.co.RequireAddCo;
import com.mango.require.entity.pojo.RequireFile;
import com.mango.require.service.IRequireService;
import com.mango.require.utils.CommonUtils;
import com.mango.require.utils.MapperUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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
    public void save(RequireAddCo requireAddCo, CurrentUser currentUser) {
        Require require = MapperUtils.mapperBean(requireAddCo, Require.class);
        require.setCreateTime(new Date());
        require.setCreateUserId(currentUser.getUserId());
        require.setModifyTime(new Date());
        require.setModifyUserId(currentUser.getUserId());
        require.setIsDel(IsDelEnum.FALSE.getValue());
        require.setStatus(RequireStatusEnum.INPLANNING.getValue());
        require.setUrgent(UrgentEnum.NOEMERGENT.getValue());
        require.setPriority(PriorityEnum.NOIMPORTANT.getValue());
        baseMapper.insert(require);
        if(StringUtils.isNotBlank(requireAddCo.getFileIds())) {
            String[] fileIds = requireAddCo.getFileIds().split(StringPool.COMMA);
            for(String fileId : fileIds) {
                requireFileMapper.insert(RequireFile.builder()
                        .fileId(Integer.valueOf(fileId))
                        .requireId(require.getRequireId())
                        .build());
            }
        }
    }

    @Override
    public void update(RequireUpdateCo requireUpdateCo, CurrentUser currentUser) {
        QueryWrapper<Require> requireQueryWrapper = new QueryWrapper<>();
        requireQueryWrapper.lambda().eq(Require::getRequireId, requireUpdateCo.getRequireId())
                .eq(Require::getIsDel, IsDelEnum.FALSE.getValue());
        if(CollectionUtils.isNotEmpty(this.baseMapper.selectList(requireQueryWrapper))) {
            Require require = MapperUtils.mapperBean(requireUpdateCo, Require.class);
            require.setModifyTime(new Date());
            require.setModifyUserId(currentUser.getUserId());
            baseMapper.updateById(require);
            if(StringUtils.isNotBlank(requireUpdateCo.getFileIds())) {
                requireFileMapper.deleteById(require.getRequireId());
                String[] fileIds = requireUpdateCo.getFileIds().split(StringPool.COMMA);
                for(String fileId : fileIds) {
                    requireFileMapper.insert(RequireFile.builder()
                            .fileId(Integer.valueOf(fileId))
                            .requireId(require.getRequireId())
                            .build());
                }
            }
        } else {
            throw new RequireException("没有该需求信息");
        }
    }

    @Override
    public PageResponse list(RequireListCo requireListCo) {
        Page<RequireVo> page = new Page<>(requireListCo.getPageIndex(), requireListCo.getPageSize());
        QueryWrapper<RequireListCo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderBy(true, requireListCo.getSortAscend(), CommonUtils.camelToUnderscore(requireListCo.getSortColumn()));
        IPage<RequireVo> requirePage = baseMapper.selectList(page, queryWrapper);
        return PageResponse.<RequireVo>builder().list(requirePage.getRecords()).total(requirePage.getTotal()).build();
    }

}
