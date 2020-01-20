package com.mango.require.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static List<Map<String, String>> list;

    private static Map<Integer, String> map;

    public static List<Map<String, String>> toList() {
        if (list == null) {
            PageEnum[] ary = PageEnum.values();
            List<Map<String, String>> listTmp = new ArrayList<>();
            for (PageEnum pageEnum : ary) {
                Map<String, String> map = new HashMap<>();
                map.put("value", String.valueOf(pageEnum.getValue()));
                map.put("name", pageEnum.getName());
                listTmp.add(map);
            }
            list = listTmp;
        }
        return list;
    }

    public static Map<Integer, String> toMap() {
        if (map == null) {
            PageEnum[] ary = PageEnum.values();
            Map<Integer, String> enumMap = new HashMap<>();
            for (PageEnum pageEnum : ary) {
                enumMap.put(pageEnum.getValue(), pageEnum.getName());
            }
            map = enumMap;
        }
        return map;
    }

    public static String getNameByValue(Integer value) {
        return toMap().get(value);
    }
}
