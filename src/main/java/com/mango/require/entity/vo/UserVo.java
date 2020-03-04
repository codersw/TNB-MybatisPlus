package com.mango.require.entity.vo;

import com.mango.require.entity.pojo.Dept;
import com.mango.require.entity.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserVo extends User {

    private Dept dept;
}
