package com.mango.require.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 是否删除枚举
 * @author swen
 */
@Getter
public enum IsDelEnum implements IEnum<Integer> {

    FALSE(0,"未删除"),
    TRUE(1,"已删除");

    @EnumValue
    private Integer value;

    @JsonValue
    private String name;

    IsDelEnum(Integer value, String name){
        this.value = value;
        this.name = name;
    }

}
