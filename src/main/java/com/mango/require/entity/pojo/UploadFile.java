package com.mango.require.entity.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 * <p>
 * 文件信息
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_upload_file")
@ApiModel(value="UploadFile对象", description="文件信息")
public class UploadFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件id")
    @TableId(value = "file_id", type = IdType.AUTO)
    private Integer fileId;

    @ApiModelProperty(value = "文件类型")
    @TableField("file_type")
    private String fileType;

    @ApiModelProperty(value = "文件路径")
    @TableField("file_path")
    private String filePath;

    @ApiModelProperty(value = "文件大小")
    @TableField("file_size")
    private Long fileSize;

    @ApiModelProperty(value = "文件名字")
    @TableField("file_name")
    private String fileName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "是否删除 0未删除 1已删除")
    @TableField("is_del")
    @TableLogic
    private Integer isDel;


}
