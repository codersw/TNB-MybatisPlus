package com.mango.require.controller;

import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.common.Result;
import com.mango.require.entity.common.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 * 当前信息接口 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-03-04
 */
@Api(value = "当前用户信息接口", tags = {"当前用户信息接口"})
@Slf4j
@RestController
@RequestMapping("/current")
public class CurrentController {

    /**
     * 列表
     * @param currentUser 当前用户信息
     * @return Result
     */
    @ApiOperation(value = "当前用户信息接口", notes = "当前用户信息接口")
    @GetMapping
    public Result current(@ApiIgnore CurrentUser currentUser) {
        return ResultGenerator.genSuccessResult(currentUser);
    }
}
