package com.mango.demand.pool.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 需求操作类型
 * @author swen
 */
@Getter
public enum RequireHandleTypeEnum {

    MERGE("merge","需求合并"),
    TAG("tag","打标签"),
    PRIORITY("priority","重要程度"),
    URGENT("urgent","紧急程度"),
    STATUS("status","状态");

    private String value;
    private String name;

    RequireHandleTypeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    private static List<Map<String, String>> list;

    private static Map<String, String> map;

    public static List<Map<String, String>> toList() {
        if (list == null) {
            RequireHandleTypeEnum[] ary = RequireHandleTypeEnum.values();
            List<Map<String, String>> listTmp = new ArrayList<>();
            for (RequireHandleTypeEnum priorityEnum : ary) {
                Map<String, String> map = new HashMap<>();
                map.put("value", String.valueOf(priorityEnum.getValue()));
                map.put("name", priorityEnum.getName());
                listTmp.add(map);
            }
            list = listTmp;
        }
        return list;
    }

    public static Map<String, String> toMap() {
        if (map == null) {
            RequireHandleTypeEnum[] ary = RequireHandleTypeEnum.values();
            Map<String, String> enumMap = new HashMap<>();
            for (RequireHandleTypeEnum priorityEnum : ary) {
                enumMap.put(priorityEnum.getValue(), priorityEnum.getName());
            }
            map = enumMap;
        }
        return map;
    }

    public static String getNameByValue(String value) {
        return toMap().get(value);
    }

    public static RequireHandleTypeEnum getEnumByValue(String value) {
        for(RequireHandleTypeEnum typeEnum : values()){
            if (typeEnum.getValue().equals(value)) {
                //获取指定的枚举
                return typeEnum;
            }
        }
        return null;
    }
}
