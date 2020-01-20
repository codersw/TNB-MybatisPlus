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


}
