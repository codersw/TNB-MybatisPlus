package com.mango.require.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 *  重写方法入参
 * @Author: swen
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private ArgumentResolver argumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(argumentResolver);
    }
}
