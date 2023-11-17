package com.example.chihong;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ={"com.example.chihong.mapper"})
public class ChihongApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChihongApplication.class, args);
    }

}
