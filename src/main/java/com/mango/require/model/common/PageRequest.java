package com.mango.require.model.common;

import com.mango.require.enums.PageEnum;
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

	@ApiModelProperty(value = "是否分页,false不分页,true分页", name = "paging", example = "true", required = true)
	private Boolean paging = true;

	@ApiModelProperty(value = "页序号", name = "pageIndex", example = "1")
	private Integer pageIndex = PageEnum.PAGE_INDEX.getValue();

	@ApiModelProperty(value = "每页条数", name = "pageSize", example = "10")
	private Integer pageSize = PageEnum.PAGE_SIZE.getValue();

	@ApiModelProperty(value = "排序true为正序，false为倒序", name = "sortAscend", example = "true")
	private Boolean sortAscend;

	@ApiModelProperty(value = "排序列", name = "sortColumn", example = "")
	private String sortColumn;
}
