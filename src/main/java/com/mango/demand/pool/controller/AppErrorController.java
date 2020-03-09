package com.mango.demand.pool.controller;


import com.mango.demand.pool.entity.common.Result;
import com.mango.demand.pool.enums.ResultCodeEnum;
import com.mango.demand.pool.utils.CookieUtil;
import com.mango.demand.pool.constant.CookieContsant;
import com.mango.demand.pool.entity.common.ResultGenerator;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

@RestController
@ApiIgnore
public class AppErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public Result error(HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 401:
                CookieUtil.set(response, CookieContsant.SESSION_ID, "", 0);
                return ResultGenerator.genResult(ResultCodeEnum.UNAUTHORIZED);
            case 404:
                return ResultGenerator.genResult(ResultCodeEnum.NOT_FOUND);
        }
        return ResultGenerator.genFailResult();
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
