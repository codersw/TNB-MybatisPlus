package com.mango.require.entity.co;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="标签新增信息", description="标签新增信息")
public class TagAddCo {

    @ApiModelProperty(value = "标签names", example = "你好,我好")
    private String tagNames;

    @ApiModelProperty(value = "标签描述", example = "标签描述")
    private String tagDesc;
}
