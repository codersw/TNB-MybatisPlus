package com.mango.require.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 是否删除枚举
 * @author swen
 */
@Getter
public enum IsDelEnum {

    FALSE(0,"未删除"),
    TRUE(1,"已删除");

    private Integer value;
    private String name;

    IsDelEnum(Integer value, String name){
        this.value = value;
        this.name = name;
    }

}
