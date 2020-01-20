package com.mango.require.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 状态值枚举
 * @author swen
 */
@Getter
public enum StatusEnum implements IEnum<Integer> {

    INPLANNING(0,"规划中"),
    REALIZED(1,"已实现"),
    REJECTED(2,"已拒绝");

    @EnumValue
    private Integer value;

    @JsonValue
    private String name;

    StatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
