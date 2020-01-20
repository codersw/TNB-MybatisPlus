package com.mango.require.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * 男女枚举
 * @author swen
 */
@Getter
public enum GenderEnum implements IEnum<Integer> {

    MALE(1,"男"),
    FEMALE(0,"女");

    @EnumValue
    private Integer value;

    private String name;

    GenderEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
