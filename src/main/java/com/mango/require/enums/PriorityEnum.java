package com.mango.require.enums;

import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 优先级枚举
 * @author swen
 */
@Getter
public enum PriorityEnum {

    IMPORTANT(1,"重要"),
    NOIMPORTANT(0,"不重要");

    private Integer value;
    private String name;

    PriorityEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static List<Map<String, String>> list;

    private static Map<Integer, String> map;

    public static List<Map<String, String>> toList() {
        if (list == null) {
            PriorityEnum[] ary = PriorityEnum.values();
            List<Map<String, String>> listTmp = new ArrayList<>();
            for (PriorityEnum priorityEnum : ary) {
                Map<String, String> map = new HashMap<>();
                map.put("value", String.valueOf(priorityEnum.getValue()));
                map.put("name", priorityEnum.getName());
                listTmp.add(map);
            }
            list = listTmp;
        }
        return list;
    }

    public static Map<Integer, String> toMap() {
        if (map == null) {
            PriorityEnum[] ary = PriorityEnum.values();
            Map<Integer, String> enumMap = new HashMap<>();
            for (PriorityEnum priorityEnum : ary) {
                enumMap.put(priorityEnum.getValue(), priorityEnum.getName());
            }
            map = enumMap;
        }
        return map;
    }

    public static String getNameByValue(Integer value) {
        return toMap().get(value);
    }
}
