package com.mango.require.entity.vo;

import com.mango.require.entity.pojo.RequireComment;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequireCommentVo extends RequireComment {

    private String createUserName;
}
