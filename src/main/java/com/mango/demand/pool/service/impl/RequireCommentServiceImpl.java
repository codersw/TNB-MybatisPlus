package com.mango.demand.pool.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.demand.pool.entity.common.PageResponse;
import com.mango.demand.pool.enums.IsDelEnum;
import com.mango.demand.pool.utils.MapperUtils;
import com.mango.demand.pool.entity.co.RequireCommentAddCo;
import com.mango.demand.pool.entity.co.RequireCommentListCo;
import com.mango.demand.pool.entity.co.RequireCommentUpdateCo;
import com.mango.demand.pool.entity.common.CurrentUser;
import com.mango.demand.pool.entity.pojo.RequireComment;
import com.mango.demand.pool.entity.vo.RequireCommentVo;
import com.mango.demand.pool.mapper.RequireCommentMapper;
import com.mango.demand.pool.service.IRequireCommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 需求评论 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-22
 */
@Service
@Transactional
public class RequireCommentServiceImpl extends ServiceImpl<RequireCommentMapper, RequireComment> implements IRequireCommentService {

    @Override
    public PageResponse list(RequireCommentListCo requireCommentListCo) {
        Page<RequireCommentVo> page = new Page<>(requireCommentListCo.getPageIndex(), requireCommentListCo.getPageSize());;
        IPage<RequireCommentVo> requirePage = baseMapper.selectList(page, requireCommentListCo);
        return PageResponse.<RequireCommentVo>builder().list(requirePage.getRecords()).total(requirePage.getTotal()).build();
    }

    @Override
    public void save(RequireCommentAddCo requireCommentAddCo, CurrentUser currentUser) {
        RequireComment comment = MapperUtils.mapperBean(requireCommentAddCo, RequireComment.class);
        comment.setCreateTime(new Date());
        comment.setCreateUserId(currentUser.getUserId());
        comment.setModifyTime(new Date());
        comment.setModifyUserId(currentUser.getUserId());
        comment.setIsDel(IsDelEnum.FALSE.getValue());
        baseMapper.insert(comment);
    }

    @Override
    public void update(RequireCommentUpdateCo requireCommentUpdateCo, CurrentUser currentUser) {
        RequireComment comment = MapperUtils.mapperBean(requireCommentUpdateCo, RequireComment.class);
        comment.setModifyUserId(currentUser.getUserId());
        comment.setModifyTime(new Date());
        baseMapper.updateById(comment);
    }
}
