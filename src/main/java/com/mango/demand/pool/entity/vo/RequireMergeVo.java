package com.mango.demand.pool.entity.vo;

import com.mango.demand.pool.entity.pojo.RequireMerge;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequireMergeVo extends RequireMerge {

    private Integer requireId;

    private String requireTitle;

    private String userName;

    private String deptName;
}
