package com.mango.require.utils;


import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * 基本工具类
 * @author swen
 */
public class CommonUtils {

    /**
     * 生成uuid
     * @return
     */
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 判断字符串是不是NULL或是空字符串,如果是，返回true，不是false
     * @param str 待判断字符串
     * @return true/false
     */
    public static boolean isNullOrEmpty(final String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断字符串对象是不是NULL或空，如果是，返回true，不是false
     * @param str 字符串对象
     * @return true/false
     */
    public static boolean isNullOrEmpty(final Object str){
        return str == null || "".equals(str.toString());
    }

    /**
     * 数组转字符串
     * @param array 数组
     * @param surffix 分割符号
     * @return
     */
    public static String array2String(final String[] array,final String surffix){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<array.length;i++){
            if(i==array.length-1){
                builder.append(array[i]);
            }
            else {
                builder.append(array[i]).append(surffix);
            }
        }
        return builder.toString();
    }

    /**
     * 获取IP地址
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        //使用代理，则获取第一个IP地址
        if(StringUtils.isEmpty(ip) && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }


    /**
     * 判断是否为 AJAX 请求
     *
     * @param request HttpServletRequest
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }

    /**
     * 驼峰转下划线
     *
     * @param value 待转换值
     * @return 结果
     */
    public static String camelToUnderscore(String value) {
        if (StringUtils.isBlank(value))
            return value;
        String[] arr = StringUtils.splitByCharacterTypeCamelCase(value);
        if (arr.length == 0)
            return value;
        StringBuilder result = new StringBuilder();
        IntStream.range(0, arr.length).forEach(i -> {
            if (i != arr.length - 1)
                result.append(arr[i]).append("_");
            else
                result.append(arr[i]);
        });
        return StringUtils.lowerCase(result.toString());
    }

    /**
     * 下划线转驼峰
     *
     * @param value 待转换值
     * @return 结果
     */
    public static String underscoreToCamel(String value) {
        StringBuilder result = new StringBuilder();
        String[] arr = value.split("_");
        for (String s : arr) {
            result.append((String.valueOf(s.charAt(0))).toUpperCase()).append(s.substring(1));
        }
        return result.toString();
    }
}
