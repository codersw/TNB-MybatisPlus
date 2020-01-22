package com.mango.require.entity.common;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class PageResponse<T> {

    @ApiModelProperty(value = "总条数")
    private Long total;

    @ApiModelProperty(value = "内容集合")
    private List<T> list;
}

