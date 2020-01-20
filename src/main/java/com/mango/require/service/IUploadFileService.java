package com.mango.require.service;

import com.mango.require.model.UploadFile;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
public interface IUploadFileService extends IService<UploadFile> {

    UploadFile save(MultipartFile file) throws Exception;
}
