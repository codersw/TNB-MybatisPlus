package com.mango.require.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mango.require.constant.CookieContsant;
import com.mango.require.entity.common.ResultGenerator;
import com.mango.require.enums.ResultCodeEnum;
import com.mango.require.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重写token验证失败返回值
 * @author swen
 */
@Slf4j
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        CookieUtil.set(response, CookieContsant.SESSION_ID, "", 0);
        log.info("{}", exception.getMessage());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(this.mapper.writeValueAsString(ResultGenerator.genResult(ResultCodeEnum.UNAUTHORIZED)));
    }
}
