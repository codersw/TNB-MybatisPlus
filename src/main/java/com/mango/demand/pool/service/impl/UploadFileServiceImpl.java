package com.mango.demand.pool.service.impl;

import com.mango.demand.pool.enums.IsDelEnum;
import com.mango.demand.pool.entity.common.CurrentUser;
import com.mango.demand.pool.entity.pojo.UploadFile;
import com.mango.demand.pool.mapper.UploadFileMapper;
import com.mango.demand.pool.service.IUploadFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.demand.pool.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * <p>
 * 文件信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class UploadFileServiceImpl extends ServiceImpl<UploadFileMapper, UploadFile> implements IUploadFileService {

    /**
     * 图片本地路径
     */
    @Value("${web.upload-path}")
    public String path ;

    @Override
    public UploadFile save(MultipartFile file, CurrentUser currentUser) throws Exception {
        UploadFile uploadFile = UploadFile.builder()
                .fileName(file.getOriginalFilename())
                .filePath(FileUtils.uploadFile(file, path))
                .fileSize(file.getSize())
                .fileType(FileUtils.getFileType(file.getOriginalFilename()))
                .createUserId(currentUser.getUserId())
                .createTime(new Date())
                .isDel(IsDelEnum.FALSE.getValue())
                .modifyUserId(currentUser.getUserId())
                .modifyTime(new Date())
                .build();
        baseMapper.insert(uploadFile);
        return uploadFile;
    }
}
