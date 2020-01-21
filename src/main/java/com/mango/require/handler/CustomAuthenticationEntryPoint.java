package com.mango.require.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mango.require.enums.ResultCodeEnum;
import com.mango.require.model.common.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Resource
    private ObjectMapper mapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(mapper.writeValueAsString(ResultGenerator.genResult(ResultCodeEnum.UNAUTHORIZED, "没有访问权限")));
    }
}
