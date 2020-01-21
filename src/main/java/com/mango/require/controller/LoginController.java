package com.mango.require.controller;

import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.common.util.KeycloakUriBuilder;
import org.keycloak.constants.ServiceUrlConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 *  登录前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@ApiIgnore
@Slf4j
@Controller
public class LoginController {

    @Resource
    private KeycloakSpringBootProperties properties;

    @GetMapping("/login")
    public String login() {
        String logoutUri = KeycloakUriBuilder.fromUri(properties.getAuthServerUrl()).path(ServiceUrlConstants.AUTH_PATH)
                .queryParam("redirect_uri", "http://192.168.4.162:9090/")
                .queryParam("client_id", properties.getResource())
                .queryParam("response_type", "code")
                .queryParam("login", true)
                .queryParam("scope", "openid")
                .build(properties.getRealm()).toString();
        return "redirect:" + logoutUri;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) throws ServletException {
        request.logout();
    }

    @GetMapping
    @ResponseBody
    public Result index() {
        return ResultGenerator.genSuccessResult("登录成功");
    }

}
