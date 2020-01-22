package com.mango.require.entity.co;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="标签新增信息", description="标签新增信息")
public class TagUpdateCo {

    @ApiModelProperty(value = "标签id", example = "1", required = true)
    private Integer tagId;

    @ApiModelProperty(value = "标签名字", example = "标签名字")
    private String tagName;

    @ApiModelProperty(value = "标签描述", example = "标签描述")
    private String tagDesc;
}
