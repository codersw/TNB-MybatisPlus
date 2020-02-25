package com.mango.require.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.require.entity.co.RequireAddCo;
import com.mango.require.entity.co.RequireAdminListCo;
import com.mango.require.entity.co.RequireListCo;
import com.mango.require.entity.co.RequireUpdateCo;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.common.PageResponse;
import com.mango.require.entity.pojo.*;
import com.mango.require.entity.vo.RequireDetailVo;
import com.mango.require.entity.vo.RequireVo;
import com.mango.require.enums.IsDelEnum;
import com.mango.require.enums.PriorityEnum;
import com.mango.require.enums.RequireStatusEnum;
import com.mango.require.enums.UrgentEnum;
import com.mango.require.exception.RequireException;
import com.mango.require.mapper.*;
import com.mango.require.service.IRequireService;
import com.mango.require.utils.MapperUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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

    @Resource
    private RequireMergeMapper requireMergeMapper;

    @Resource
    private RequireTagMapper requireTagMapper;

    @Resource
    private UploadFileMapper uploadFileMapper;

    @Resource
    private TagMapper tagMapper;

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
            if(StringUtils.isNotEmpty(requireUpdateCo.getFileIds())) {
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
    public void merge(Integer masterId, String branchIds, CurrentUser currentUser) {
        if(StringUtils.isNotEmpty(branchIds)) {
            UpdateWrapper<RequireMerge> updateWrapper = new UpdateWrapper<>();
            updateWrapper.lambda().eq(RequireMerge::getRequireMasterId, masterId);
            requireMergeMapper.delete(updateWrapper);
            String[] ids = branchIds.split(StringPool.COMMA);
            for(String id : ids) {
                requireMergeMapper.insert(RequireMerge.builder()
                        .requireMasterId(masterId)
                        .requireBranchId(Integer.valueOf(id))
                        .modifyTime(new Date())
                        .createTime(new Date())
                        .createUserId(currentUser.getUserId())
                        .modifyUserId(currentUser.getUserId())
                        .build());
            }
        }
    }

    @Override
    public void tag(Integer requireId, String tagIds) {
        if(StringUtils.isNotEmpty(tagIds)) {
            UpdateWrapper<RequireTag> updateWrapper = new UpdateWrapper<>();
            updateWrapper.lambda().eq(RequireTag::getRequireId, requireId);
            requireTagMapper.delete(updateWrapper);
            String[] ids = tagIds.split(StringPool.COMMA);
            for(String id : ids) {
                requireTagMapper.insert(RequireTag.builder()
                        .requireId(requireId)
                        .tagId(Integer.valueOf(id))
                        .build());
            }
        }
    }

    @Override
    public void priority(Integer requireId, Integer priority, CurrentUser currentUser) {
        if(StringUtils.isEmpty(PriorityEnum.toMap().get(priority))) throw new RequireException("参数错误");
        baseMapper.updateById(Require.builder()
                .requireId(requireId)
                .priority(priority)
                .modifyTime(new Date())
                .createTime(new Date())
                .createUserId(currentUser.getUserId())
                .modifyUserId(currentUser.getUserId())
                .build());
    }

    @Override
    public void urgent(Integer requireId, Integer urgent, CurrentUser currentUser) {
        if(StringUtils.isEmpty(UrgentEnum.toMap().get(urgent))) throw new RequireException("参数错误");
        baseMapper.updateById(Require.builder()
                .requireId(requireId)
                .urgent(urgent)
                .modifyTime(new Date())
                .createTime(new Date())
                .createUserId(currentUser.getUserId())
                .modifyUserId(currentUser.getUserId())
                .build());
    }

    @Override
    public void status(Integer requireId, Integer status, CurrentUser currentUser) {
        if(StringUtils.isEmpty(RequireStatusEnum.toMap().get(status))) throw new RequireException("参数错误");
        baseMapper.updateById(Require.builder()
                .requireId(requireId)
                .status(status)
                .modifyTime(new Date())
                .createTime(new Date())
                .createUserId(currentUser.getUserId())
                .modifyUserId(currentUser.getUserId())
                .build());
    }

    @Override
    public PageResponse adminList(RequireAdminListCo requireAdminListCo) {
        Page<RequireVo> page = new Page<>(requireAdminListCo.getPageIndex(), requireAdminListCo.getPageSize());;
        IPage<RequireVo> requirePage = baseMapper.selectAdminList(page, requireAdminListCo);
        return PageResponse.<RequireVo>builder().list(requirePage.getRecords()).total(requirePage.getTotal()).build();
    }

    @Override
    public PageResponse list(RequireListCo requireListCo) {
        Page<RequireVo> page = new Page<>(requireListCo.getPageIndex(), requireListCo.getPageSize());;
        IPage<RequireVo> requirePage = baseMapper.selectList(page, requireListCo);
        return PageResponse.<RequireVo>builder().list(requirePage.getRecords()).total(requirePage.getTotal()).build();
    }

    @Override
    public RequireDetailVo detail(Integer requireId) {
        Require require = baseMapper.selectById(requireId);
        if(require == null) throw new RequireException("没有该需求信息");
        RequireDetailVo requireDetailVo = MapperUtils.mapperBean(require, RequireDetailVo.class);
        requireDetailVo.setFiles(uploadFileMapper.selectByRequireId(requireId));
        requireDetailVo.setTags(tagMapper.selectByRequireId(requireId));
        requireDetailVo.setBranchs(requireMergeMapper.selectBranchs(requireId));
        requireDetailVo.setMaster(requireMergeMapper.selectMaster(requireId));
        return requireDetailVo;
    }

}
