package com.mango.require.model.common;


import com.mango.require.constant.MdcConstant;
import com.mango.require.enums.ResultCodeEnum;
import org.slf4j.MDC;

/**
 * 接口返回值生成工具
 * @author swen
 */
public class ResultGenerator {

    /**
     * 成功不返回参数
     * @return
     */
    public static Result genSuccessResult() {
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS.getValue());
        result.setMessage(ResultCodeEnum.SUCCESS.getName());
        result.setRequestId(MDC.get(MdcConstant.REQUEST_ID));
        return result;
    }

    /**
     * 成功返回参数
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> genSuccessResult(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.SUCCESS.getValue());
        result.setMessage(ResultCodeEnum.SUCCESS.getName());
        result.setData(data);
        result.setRequestId(MDC.get(MdcConstant.REQUEST_ID));
        return result;
    }

    /**
     * 失败不返回原因
     * @return
     */
    public static Result genFailResult() {
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL.getValue());
        result.setMessage(ResultCodeEnum.FAIL.getName());
        result.setRequestId(MDC.get(MdcConstant.REQUEST_ID));
        return result;
    }

    /**
     * 失败返回原因
     * @param message
     * @return
     */
    public static Result<?> genFailResult(String message) {
        Result<?> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL.getValue());
        result.setMessage(message);
        result.setRequestId(MDC.get(MdcConstant.REQUEST_ID));
        return result;
    }

    /**
     * 自定义创建返回体
     * @param codeEnum
     * @param message
     * @return
     */
    public static Result<?> genResult(ResultCodeEnum codeEnum, String message) {
        Result<?> result = new Result<>();
        result.setCode(codeEnum.getValue());
        result.setMessage(message);
        result.setRequestId(MDC.get(MdcConstant.REQUEST_ID));
        return result;
    }

    /**
     * 自定义创建返回体
     * @param codeEnum
     * @return
     */
    public static Result<?> genResult(ResultCodeEnum codeEnum) {
        Result<?> result = new Result<>();
        result.setCode(codeEnum.getValue());
        result.setMessage(codeEnum.getName());
        result.setRequestId(MDC.get(MdcConstant.REQUEST_ID));
        return result;
    }
}
