package com.mango.require.handler;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mango.require.entity.common.ResultGenerator;
import com.mango.require.enums.ResultCodeEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(this.mapper.writeValueAsString(JSONObject.toJSONString(ResultGenerator.genResult(ResultCodeEnum.UNAUTHORIZED))));
    }
}
