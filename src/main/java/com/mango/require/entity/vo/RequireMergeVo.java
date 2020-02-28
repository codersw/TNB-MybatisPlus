package com.mango.require.entity.vo;

import com.mango.require.entity.pojo.RequireMerge;
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
