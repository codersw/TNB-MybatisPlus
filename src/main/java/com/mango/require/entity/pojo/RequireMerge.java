package com.mango.require.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 需求合并
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_require_merge")
@ApiModel(value="RequireMerge对象", description="需求合并")
public class RequireMerge implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主需求id")
    @TableId("require_master_id")
    private Integer requireMasterId;

    @ApiModelProperty(value = "分支需求id")
    @TableField("require_branch_id")
    private Integer requireBranchId;

    @ApiModelProperty(value = "创建人")
    @TableField("create_user_id")
    private Integer createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("modify_user_id")
    private Integer modifyUserId;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;
}
