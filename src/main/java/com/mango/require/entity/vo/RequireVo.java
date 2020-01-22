package com.mango.require.entity.vo;

import com.mango.require.entity.pojo.Require;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequireVo extends Require {

    private Integer tagId;

    private String tagName;

    private String tagDesc;
}
