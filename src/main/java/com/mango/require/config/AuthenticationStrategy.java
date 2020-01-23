package com.mango.require.config;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mango.require.entity.common.ResultGenerator;
import com.mango.require.enums.ResultCodeEnum;
import com.mango.require.utils.CommonUtils;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationStrategy implements SessionAuthenticationStrategy {

    private ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response)  {
        Object o = authentication.getDetails();
        if(CommonUtils.isNullOrEmpty(o)) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(this.mapper.writeValueAsString(JSONObject.toJSONString(ResultGenerator.genResult(ResultCodeEnum.UNAUTHORIZED))));
        }
    }
}
