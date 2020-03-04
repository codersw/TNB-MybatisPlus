package com.mango.require.entity.common;


import com.mango.require.enums.SexEnum;
import lombok.Data;

@Data
public class CurrentUser {

    private Integer userId;

    private String username;

    private String password;

    private String mobile;

    private Integer sex;

    private String sexName;

    private Integer deptId;

    private String deptName;

    public String getSexName() {
        return SexEnum.getNameByValue(this.sex);
    }

}
