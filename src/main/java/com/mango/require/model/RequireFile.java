package com.mango.require.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 * <p>
 * 需求附件信息
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_require_file")
@ApiModel(value="RequireFile对象", description="需求附件信息")
public class RequireFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需求id")
    @TableId("require_id")
    private Integer requireId;

    @ApiModelProperty(value = "文件id")
    @TableField("file_id")
    private Integer fileId;


}
