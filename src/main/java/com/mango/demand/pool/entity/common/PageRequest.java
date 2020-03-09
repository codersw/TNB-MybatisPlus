package com.mango.demand.pool.entity.common;

import com.mango.demand.pool.enums.PageEnum;
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
@ApiModel
public class PageRequest {

	@ApiModelProperty(value = "页序号", name = "pageIndex", example = "1")
	private Integer pageIndex = PageEnum.PAGE_INDEX.getValue();

	@ApiModelProperty(value = "每页条数", name = "pageSize", example = "10")
	private Integer pageSize = PageEnum.PAGE_SIZE.getValue();
}
