package com.mango.demand.pool.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * cookie操作类
 * @author swen
 */
public class CookieUtil {

    /**
     * 设置Cookie
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response, String name, String value, int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 设置Cookie
     * @param response
     * @param name
     * @param value
     */
    public static void set(HttpServletResponse response, String name, String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
    }


    /**
     * 获取Cookie
     * @param request
     * @param name
     * @return
     */
    public static String get(HttpServletRequest request, String name){
        Map<String, Cookie> map = readCookieMap(request);
        if(map.containsKey(name)){
            return map.get(name).getValue();
        }else{
            //cookie中没有去请求头中找
            return request.getHeader(name);
        }
    }

    /**
     * 将cookie封装成map
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Map<String, Cookie> map = new HashMap<>();
        if(cookies != null){
            for(Cookie cookie : cookies){
                map.put(cookie.getName(),cookie);
            }
        }
        return map;
    }
}
