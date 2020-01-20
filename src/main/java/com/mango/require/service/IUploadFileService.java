package com.mango.require.service;

import com.mango.require.model.UploadFile;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;

/**
 * <p>
 * 文件信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-01-19
 */
public interface IUploadFileService extends IService<UploadFile> {

     PageResponse<UploadFile> uploadFileList(UploadFile uploadFile, PageRequest pageRequest);
}
