package com.mango.demand.pool.enums;


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
public enum UserStatusEnum {

    NOBLOCK(0,"未锁定"),
    ISBLOCK(1,"已锁定");

    private Integer value;
    private String name;

    UserStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static List<Map<String, String>> list;

    private static Map<Integer, String> map;

    public static List<Map<String, String>> toList() {
        if (list == null) {
            UserStatusEnum[] ary = UserStatusEnum.values();
            List<Map<String, String>> listTmp = new ArrayList<>();
            for (UserStatusEnum statusEnum : ary) {
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
            UserStatusEnum[] ary = UserStatusEnum.values();
            Map<Integer, String> enumMap = new HashMap<>();
            for (UserStatusEnum statusEnum : ary) {
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
