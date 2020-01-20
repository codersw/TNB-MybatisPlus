package com.mango.require.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * 紧急程度枚举
 * @author swen
 */
@Getter
public enum UrgentEnum implements IEnum<Integer> {

    EMERGENT(1,"紧急"),
    NOEMERGENT(0,"不紧急");

    @EnumValue
    private Integer value;

    private String name;

    UrgentEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
