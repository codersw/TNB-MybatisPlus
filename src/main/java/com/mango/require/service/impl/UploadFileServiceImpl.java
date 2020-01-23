package com.mango.require.service.impl;

import com.mango.require.enums.IsDelEnum;
import com.mango.require.entity.pojo.UploadFile;
import com.mango.require.mapper.UploadFileMapper;
import com.mango.require.service.IUploadFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.require.utils.FileUtils;
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
    public UploadFile save(MultipartFile file) throws Exception {
        UploadFile uploadFile = UploadFile.builder()
                .fileName(file.getOriginalFilename())
                .filePath(FileUtils.uploadFile(file, path))
                .fileSize(file.getSize())
                .fileType(FileUtils.getFileType(file.getOriginalFilename()))
                .createTime(new Date())
                .isDel(IsDelEnum.FALSE.getValue())
                .modifyTime(new Date())
                .build();
        baseMapper.insert(uploadFile);
        return uploadFile;
    }
}
