package com.mango.require.entity.vo;

import com.mango.require.entity.pojo.Require;
import com.mango.require.enums.PriorityEnum;
import com.mango.require.enums.RequireStatusEnum;
import com.mango.require.enums.UrgentEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequireListVo extends Require {

    private String priorityName;

    private String urgentName;

    private String statusName;

    private String tagNames;

    private String userName;

    private String deptName;

    public String getPriorityName() {
        return PriorityEnum.getNameByValue(this.getPriority());
    }

    public String getUrgentName() {
        return UrgentEnum.getNameByValue(this.getUrgent());
    }

    public String getStatusName() {
        return RequireStatusEnum.getNameByValue(this.getStatus());
    }
}
