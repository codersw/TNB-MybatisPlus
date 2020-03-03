package com.mango.require.aspect;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mango.require.constant.MdcConstant;
import com.mango.require.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * aop切点记录请求与响应日志
 * @author swen
 */
@Aspect
@Component
@Slf4j
public class ControllerAspect {

    /** 以 controller 包下定义的所有请求为切入点 */
    @Pointcut("execution(public * com.mango.require.controller.*.*(..)) || target(com.mango.require.handler.GlobalExceptionHandler)))")
    public void webLog() {}

    /**
     * 在切点之前织入
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        String requestId = CommonUtils.UUID();
        MDC.put(MdcConstant.REQUEST_ID,requestId);
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        log.info("Start RequestId : {}", requestId);
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("IP             : {}", CommonUtils.getIpAddr(request));
        // 打印请求入参
        log.info("Request Args   : {}", JSONObject.toJSONString(joinPoint.getArgs(), SerializerFeature.IgnoreNonFieldGetter));
    }

    /**
     * 在切点之后织入
     */
    @After("webLog()")
    public void doAfter() {
        log.info("End RequestId : {}", MDC.get(MdcConstant.REQUEST_ID));
        // 每个请求之间空一行
        log.info("");
        MDC.clear();
    }

    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("Response Args  : {}", JSONObject.toJSONString(result, SerializerFeature.IgnoreNonFieldGetter));
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        // 处理完请求，返回内容
        return result;
    }


}
