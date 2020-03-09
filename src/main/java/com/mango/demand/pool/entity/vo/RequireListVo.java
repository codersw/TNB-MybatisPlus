package com.mango.demand.pool.entity.vo;

import com.mango.demand.pool.entity.pojo.Require;
import com.mango.demand.pool.enums.PriorityEnum;
import com.mango.demand.pool.enums.RequireStatusEnum;
import com.mango.demand.pool.enums.UrgentEnum;
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
