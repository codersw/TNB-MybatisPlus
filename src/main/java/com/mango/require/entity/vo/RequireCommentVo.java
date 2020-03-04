package com.mango.require.entity.vo;

import com.mango.require.entity.pojo.RequireComment;
import com.mango.require.utils.DateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequireCommentVo extends RequireComment {

    private String userName;

    private String deptName;

    private String userPhoto;

    private Integer floor;

    private String commentTime;

    public String getCommentTime() {
        return DateUtils.relativeDateFormat(this.getCreateTime());
    }
}
