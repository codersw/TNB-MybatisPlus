package com.mango.demand.pool.entity.co;

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
@ApiModel(value="需求添加信息", description="需求添加信息")
public class RequireAddCo {

    @ApiModelProperty(value = "需求标题", example = "需求标题")
    private String requireTitle;

    @ApiModelProperty(value = "需求内容", example = "需求内容")
    private String content;

    @ApiModelProperty(value = "文件ids", example = "1,2,3")
    private String fileIds;
}
