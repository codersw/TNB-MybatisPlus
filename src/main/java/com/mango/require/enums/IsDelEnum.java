package com.mango.require.enums;

/**
 * 是否删除枚举
 * @author swen
 */
public enum IsDelEnum implements BaseEnum {

    FALSE(0,"未删除"),
    TRUE(1,"已删除");

    private Integer value;
    private String name;

    IsDelEnum(Integer value, String name){
        this.value = value;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }

}
