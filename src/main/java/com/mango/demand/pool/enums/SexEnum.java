package com.mango.demand.pool.enums;

import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 男女枚举
 * @author swen
 */
@Getter
public enum SexEnum {

    MALE(0,"男"),
    FEMALE(1,"女");

    private Integer value;
    private String name;

    SexEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static List<Map<String, String>> list;

    private static Map<Integer, String> map;

    public static List<Map<String, String>> toList() {
        if (list == null) {
            SexEnum[] ary = SexEnum.values();
            List<Map<String, String>> listTmp = new ArrayList<>();
            for (SexEnum sexEnum : ary) {
                Map<String, String> map = new HashMap<>();
                map.put("value", String.valueOf(sexEnum.getValue()));
                map.put("name", sexEnum.getName());
                listTmp.add(map);
            }
            list = listTmp;
        }
        return list;
    }

    public static Map<Integer, String> toMap() {
        if (map == null) {
            SexEnum[] ary = SexEnum.values();
            Map<Integer, String> enumMap = new HashMap<>();
            for (SexEnum sexEnum : ary) {
                enumMap.put(sexEnum.getValue(), sexEnum.getName());
            }
            map = enumMap;
        }
        return map;
    }

    public static String getNameByValue(Integer value) {
        return toMap().get(value);
    }
}
