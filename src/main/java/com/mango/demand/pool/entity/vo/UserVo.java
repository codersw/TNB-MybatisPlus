package com.mango.demand.pool.entity.vo;

import com.mango.demand.pool.entity.pojo.Dept;
import com.mango.demand.pool.entity.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserVo extends User {

    private Dept dept;
}
