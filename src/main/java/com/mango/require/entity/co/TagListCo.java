package com.mango.require.entity.co;

import com.mango.require.entity.common.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value="标签列表查询信息", description="标签需求列表查询信息")
public class TagListCo extends PageRequest {

    @ApiModelProperty(value = "关键字", example = "关键字")
    private String keyword;
}
