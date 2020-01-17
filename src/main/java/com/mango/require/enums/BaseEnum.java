package com.mango.require.enums;

/**
 * 枚举基础接口
 * @param <T>
 * @author swen
 */
public interface BaseEnum<T> {

    T getValue();

    T getName();
}
