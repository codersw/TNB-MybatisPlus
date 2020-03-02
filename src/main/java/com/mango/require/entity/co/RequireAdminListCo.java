package com.mango.require.entity.co;

import com.mango.require.entity.common.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value="需求列表查询信息", description="需求列表查询信息")
public class RequireAdminListCo extends PageRequest {

    @ApiModelProperty(value = "需求标题", example = "需求标题")
    private String requireTitle;

    @ApiModelProperty(value = "提出人", example = "提出人")
    private String userName;

    @ApiModelProperty(value = "需求状态")
    private Integer status;

    @ApiModelProperty(value = "标签id")
    private Integer tagId;
}
