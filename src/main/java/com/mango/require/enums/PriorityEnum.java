package com.mango.require.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * 优先级枚举
 * @author swen
 */
@Getter
public enum PriorityEnum implements IEnum<Integer> {

    IMPORTANT(1,"重要"),
    NOIMPORTANT(0,"不重要");

    @EnumValue
    private Integer value;

    private String name;

    PriorityEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
