package com.mango.require;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mango.require.mapper")
public class RequireApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequireApplication.class, args);
    }

}
