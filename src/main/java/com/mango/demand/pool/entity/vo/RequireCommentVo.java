package com.mango.demand.pool.entity.vo;

import com.mango.demand.pool.utils.DateUtils;
import com.mango.demand.pool.entity.pojo.RequireComment;
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
