package com.mango.require.entity.pojo;

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
 * 需求标签信息
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_require_tag")
@ApiModel(value="RequireTag对象", description="需求标签信息")
public class RequireTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需求id")
    @TableId("require_id")
    private Integer requireId;

    @ApiModelProperty(value = "标签id")
    @TableField("tag_id")
    private Integer tagId;


}
