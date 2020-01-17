package com.mango.require.enums;

/**
 * 分页参数
 * @author swen
 */
public enum PageEnum implements BaseEnum {

    PAGE_INDEX(1,"page_index"),
    PAGE_SIZE(10,"page_size");

    private Integer value;
    private String name;

    PageEnum(Integer value, String name){
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
