package com.mango.demand.pool.entity.co;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="修改评论信息", description="修改评论信息")
public class RequireCommentUpdateCo {

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "评论id")
    private Integer commentId;
}
