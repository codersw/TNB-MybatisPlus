package com.mango.require.entity.vo;

import com.mango.require.entity.pojo.Require;
import com.mango.require.entity.pojo.Tag;
import com.mango.require.entity.pojo.UploadFile;
import com.mango.require.enums.PriorityEnum;
import com.mango.require.enums.RequireStatusEnum;
import com.mango.require.enums.UrgentEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequireDetailVo extends Require {

    private List<Tag> tags;

    private String priorityName;

    private String urgentName;

    private String statusName;

    private List<RequireMergeVo> branchs;

    private RequireMergeVo master;

    private List<UploadFile> files;

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
