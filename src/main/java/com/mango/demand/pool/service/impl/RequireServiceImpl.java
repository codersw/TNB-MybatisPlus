package com.mango.demand.pool.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.demand.pool.entity.co.RequireListCo;
import com.mango.demand.pool.entity.co.RequireUpdateCo;
import com.mango.demand.pool.entity.common.PageResponse;
import com.mango.demand.pool.entity.pojo.*;
import com.mango.demand.pool.enums.IsDelEnum;
import com.mango.demand.pool.enums.PriorityEnum;
import com.mango.demand.pool.enums.RequireStatusEnum;
import com.mango.demand.pool.enums.UrgentEnum;
import com.mango.demand.pool.mapper.*;
import com.mango.demand.pool.utils.CommonUtils;
import com.mango.demand.pool.utils.MapperUtils;
import com.mango.demand.pool.entity.co.RequireAddCo;
import com.mango.demand.pool.entity.co.RequireAdminListCo;
import com.mango.demand.pool.entity.common.CurrentUser;
import com.mango.require.entity.pojo.*;
import com.mango.demand.pool.entity.vo.RequireDetailVo;
import com.mango.demand.pool.entity.vo.RequireListVo;
import com.mango.demand.pool.exception.RequireException;
import com.mango.require.mapper.*;
import com.mango.demand.pool.service.IRequireService;
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

    @Resource
    private UserMapper userMapper;

    @Resource
    private DeptMapper deptMapper;

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
        if(!CommonUtils.isNullOrEmpty(baseMapper.selectById(requireUpdateCo.getRequireId()))) {
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
            if(StringUtils.isNotEmpty(requireUpdateCo.getTagIds())) {
                requireTagMapper.deleteById(require.getRequireId());
                String[] tagIds = requireUpdateCo.getTagIds().split(StringPool.COMMA);
                for(String tagId : tagIds) {
                    requireTagMapper.insert(RequireTag.builder()
                            .tagId(Integer.valueOf(tagId))
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
        Page<RequireListVo> page = new Page<>(requireAdminListCo.getPageIndex(), requireAdminListCo.getPageSize());;
        IPage<RequireListVo> requirePage = baseMapper.selectAdminList(page, requireAdminListCo);
        return PageResponse.<RequireListVo>builder().list(requirePage.getRecords()).total(requirePage.getTotal()).build();
    }

    @Override
    public PageResponse list(RequireListCo requireListCo) {
        Page<RequireListVo> page = new Page<>(requireListCo.getPageIndex(), requireListCo.getPageSize());;
        IPage<RequireListVo> requirePage = baseMapper.selectList(page, requireListCo);
        return PageResponse.<RequireListVo>builder().list(requirePage.getRecords()).total(requirePage.getTotal()).build();
    }

    @Override
    public RequireDetailVo detail(Integer requireId) {
        Require require = baseMapper.selectById(requireId);
        if(require == null) throw new RequireException("没有该需求信息");
        RequireDetailVo requireDetailVo = MapperUtils.mapperBean(require, RequireDetailVo.class);
        User createUser = userMapper.selectById(require.getCreateUserId());
        requireDetailVo.setUserName(createUser.getUserName());
        requireDetailVo.setDeptName(deptMapper.selectById(createUser.getDeptId()).getDeptName());
        requireDetailVo.setFiles(uploadFileMapper.selectByRequireId(requireId));
        requireDetailVo.setTags(tagMapper.selectByRequireId(requireId));
        requireDetailVo.setBranchs(requireMergeMapper.selectBranchs(requireId));
        requireDetailVo.setMaster(requireMergeMapper.selectMaster(requireId));
        return requireDetailVo;
    }

}
