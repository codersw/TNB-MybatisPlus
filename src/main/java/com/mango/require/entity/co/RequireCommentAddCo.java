package com.mango.require.entity.co;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="添加评论信息", description="添加评论信息")
public class RequireCommentAddCo {

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "需求id")
    private Integer requireId;
}
