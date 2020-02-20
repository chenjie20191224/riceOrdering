package com.springbook.rice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.springbook.rice.mapper"})
public class RiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiceApplication.class, args);
    }

}
