package com.mango.require.enums;


import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 状态值枚举
 * @author swen
 */
@Getter
public enum StatusEnum {

    INPLANNING(0,"规划中"),
    REALIZED(1,"已实现"),
    REJECTED(2,"已拒绝");

    private Integer value;
    private String name;

    StatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static List<Map<String, String>> list;

    private static Map<Integer, String> map;

    public static List<Map<String, String>> toList() {
        if (list == null) {
            StatusEnum[] ary = StatusEnum.values();
            List<Map<String, String>> listTmp = new ArrayList<>();
            for (StatusEnum statusEnum : ary) {
                Map<String, String> map = new HashMap<>();
                map.put("value", String.valueOf(statusEnum.getValue()));
                map.put("name", statusEnum.getName());
                listTmp.add(map);
            }
            list = listTmp;
        }
        return list;
    }

    public static Map<Integer, String> toMap() {
        if (map == null) {
            StatusEnum[] ary = StatusEnum.values();
            Map<Integer, String> enumMap = new HashMap<>();
            for (StatusEnum statusEnum : ary) {
                enumMap.put(statusEnum.getValue(), statusEnum.getName());
            }
            map = enumMap;
        }
        return map;
    }

    public static String getNameByValue(Integer value) {
        return toMap().get(value);
    }
}
