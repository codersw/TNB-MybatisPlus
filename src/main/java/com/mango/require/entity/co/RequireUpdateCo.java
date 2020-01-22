package com.mango.require.entity.co;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value="需求修改信息", description="需求修改信息")
public class RequireUpdateCo {

    @ApiModelProperty(value = "需求id", required = true, example = "1")
    private Integer requireId;

    @ApiModelProperty(value = "需求标题", example = "需求标题")
    private String requireTitle;

    @ApiModelProperty(value = "需求内容", example = "需求内容")
    private String content;

    @ApiModelProperty(value = "文件ids", example = "1,2,3")
    private String fileIds;
}
