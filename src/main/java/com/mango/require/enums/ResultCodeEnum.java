package com.mango.require.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应值枚举
 * @author swen
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(400,"失败"),
    UNAUTHORIZED(401,"未认证（签名错误）"),
    NOT_FOUND(404,"页面丢失在异次元"),
    INTERNAL_SERVER_ERROR(500,"系统错误"),
    LOGOUT(998,""),
    APISUCCESS(0,"API调用成功"),
    APIFAIL(1,"API调用失败");

    private Integer value;
    private String name;

    ResultCodeEnum(Integer value, String name){
        this.value = value;
        this.name = name;
    }

    private static List<Map<String, String>> list;

    private static Map<Integer, String> map;

    public static List<Map<String, String>> toList() {
        if (list == null) {
            ResultCodeEnum[] ary = ResultCodeEnum.values();
            List<Map<String, String>> listTmp = new ArrayList<>();
            for (ResultCodeEnum resultCodeEnum : ary) {
                Map<String, String> map = new HashMap<>();
                map.put("value", String.valueOf(resultCodeEnum.getValue()));
                map.put("name", resultCodeEnum.getName());
                listTmp.add(map);
            }
            list = listTmp;
        }
        return list;
    }

    public static Map<Integer, String> toMap() {
        if (map == null) {
            ResultCodeEnum[] ary = ResultCodeEnum.values();
            Map<Integer, String> enumMap = new HashMap<>();
            for (ResultCodeEnum resultCodeEnum : ary) {
                enumMap.put(resultCodeEnum.getValue(), resultCodeEnum.getName());
            }
            map = enumMap;
        }
        return map;
    }

    public static String getNameByValue(Integer value) {
        return toMap().get(value);
    }
}
