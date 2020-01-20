package com.mango.require.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 紧急程度枚举
 * @author swen
 */
@Getter
public enum UrgentEnum implements IEnum<Integer> {

    EMERGENT(1,"紧急"),
    NOEMERGENT(0,"不紧急");

    @EnumValue
    private Integer value;

    @JsonValue
    private String name;

    UrgentEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static List<Map<String, String>> list;

    private static Map<Integer, String> map;

    public static List<Map<String, String>> toList() {
        if (list == null) {
            UrgentEnum[] ary = UrgentEnum.values();
            List<Map<String, String>> listTmp = new ArrayList<>();
            for (UrgentEnum urgentEnum : ary) {
                Map<String, String> map = new HashMap<>();
                map.put("value", String.valueOf(urgentEnum.getValue()));
                map.put("name", urgentEnum.getName());
                listTmp.add(map);
            }
            list = listTmp;
        }
        return list;
    }

    public static Map<Integer, String> toMap() {
        if (map == null) {
            UrgentEnum[] ary = UrgentEnum.values();
            Map<Integer, String> enumMap = new HashMap<>();
            for (UrgentEnum urgentEnum : ary) {
                enumMap.put(urgentEnum.getValue(), urgentEnum.getName());
            }
            map = enumMap;
        }
        return map;
    }

    public static String getNameByValue(Integer value) {
        return toMap().get(value);
    }
}
