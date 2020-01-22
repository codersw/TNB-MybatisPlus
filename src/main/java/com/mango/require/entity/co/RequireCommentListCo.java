package com.mango.require.entity.co;

import com.mango.require.entity.common.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value="评论列表信息", description="评论列表信息")
public class RequireCommentListCo extends PageRequest {

    @ApiModelProperty(value = "需求id")
    private Integer requireId;
}
