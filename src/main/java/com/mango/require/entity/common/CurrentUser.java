package com.mango.require.entity.common;


import com.mango.require.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrentUser {

    private Integer userId;

    private String userName;

    private String password;

    private String mobile;

    private Integer sex;

    private String sexName;

    private Integer deptId;

    private String deptName;

    private String permissions;

    public String getSexName() {
        return SexEnum.getNameByValue(this.sex);
    }

}
