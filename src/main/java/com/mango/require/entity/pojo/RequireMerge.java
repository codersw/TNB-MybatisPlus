package com.mango.require.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * 需求合并
 * </p>
 *
 * @author swen
 * @since 2020-01-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_require_merge")
@ApiModel(value="RequireMerge对象", description="需求合并")
public class RequireMerge implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "merge_id", type = IdType.AUTO)
    private Integer mergeId;

    @ApiModelProperty(value = "主需求id")
    @TableField("require_master_id")
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

    @ApiModelProperty(value = "是否删除 0未删除 1 已删除")
    @TableField("is_del")
    @TableLogic
    private Integer isDel;


}
