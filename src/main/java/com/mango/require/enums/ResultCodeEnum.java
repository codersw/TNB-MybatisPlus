package com.mango.require.enums;

/**
 * 响应值枚举
 * @author swen
 */
public enum ResultCodeEnum implements BaseEnum {

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

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }

}
