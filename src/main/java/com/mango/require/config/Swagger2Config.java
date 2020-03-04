package com.mango.require.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 *  swagger配置
 * @Author: swen
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 默认分组 返回所有接口
     * @return
     */
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mango.require"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    /**
     * api信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                //创建人
                .contact(new Contact("swen", "", ""))
                .description("API 描述")
                .version("1.0")
                .build();
    }
}
