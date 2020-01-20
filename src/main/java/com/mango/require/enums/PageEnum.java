package com.mango.require.enums;

import lombok.Getter;

/**
 * 分页参数
 * @author swen
 */
@Getter
public enum PageEnum{

    PAGE_INDEX(1,"page_index"),
    PAGE_SIZE(10,"page_size");

    private Integer value;
    private String name;

    PageEnum(Integer value, String name){
        this.value = value;
        this.name = name;
    }
}
