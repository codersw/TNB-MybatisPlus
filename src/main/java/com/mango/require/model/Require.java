package com.mango.require.model;

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
 * 需求信息
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_require")
@ApiModel(value="Require对象", description="需求信息")
public class Require implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需求id")
    @TableId(value = "require_id", type = IdType.AUTO)
    private Integer requireId;

    @ApiModelProperty(value = "需求标题")
    @TableField("require_title")
    private String requireTitle;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "重要程度")
    @TableField("priority")
    private Integer priority;

    @ApiModelProperty(value = "紧急程度")
    @TableField("urgent")
    private Integer urgent;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "创建人id")
    @TableField("create_user_id")
    private Integer createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改人id")
    @TableField("modify_user_id")
    private Integer modifyUserId;

    @TableField("modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "父级id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "是否删除 0未删除 1以删除")
    @TableField("is_del")
    @TableLogic
    private Integer isDel;


}
