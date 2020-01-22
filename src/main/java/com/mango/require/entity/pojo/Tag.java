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
 * 标签信息
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_tag")
@ApiModel(value="Tag对象", description="标签信息")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签id")
    @TableId(value = "tag_id", type = IdType.AUTO)
    private Integer tagId;

    @ApiModelProperty(value = "标签名字")
    @TableField("tag_name")
    private String tagName;

    @ApiModelProperty(value = "标签描述")
    @TableField("tag_desc")
    private String tagDesc;

    @ApiModelProperty(value = "创建人id")
    @TableField("create_user_id")
    private Integer createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改人id")
    @TableField("modify_user_id")
    private Integer modifyUserId;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "是否删除 0未删除 1 以删除")
    @TableField("is_del")
    @TableLogic
    private Integer isDel;


}
