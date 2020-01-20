package com.mango.require.service.impl;

import com.mango.require.model.UploadFile;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;
import com.mango.require.mapper.UploadFileMapper;
import com.mango.require.service.IUploadFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * <p>
 * 文件信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
@Service
@Transactional
public class UploadFileServiceImpl extends ServiceImpl<UploadFileMapper, UploadFile> implements IUploadFileService {

     @Override
     public PageResponse<UploadFile> uploadFileList(UploadFile uploadFile, PageRequest pageRequest) {
          QueryWrapper<UploadFile> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //返回值
          PageResponse<UploadFile> response = PageResponse.<UploadFile>builder().build();
          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          //分页
          if(pageRequest.getPaging()) {
               Page<UploadFile> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
               IPage<UploadFile> userPage = this.baseMapper.selectPage(page, queryWrapper);
               response.setList(userPage.getRecords());
               response.setTotal(userPage.getTotal());
          } else {
               List<UploadFile> userList = this.baseMapper.selectList(queryWrapper);
               response.setList(userList);
               response.setTotal((long) userList.size());
          }
          return response;
     }
 }
