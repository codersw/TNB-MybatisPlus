package com.mango.require.entity.co;

import com.mango.require.entity.common.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value="需求列表查询信息", description="需求列表查询信息")
public class RequireListCo extends PageRequest {

    @ApiModelProperty(value = "重要程度")
    private Integer priority;

    @ApiModelProperty(value = "紧急程度")
    private Integer urgent;
}
