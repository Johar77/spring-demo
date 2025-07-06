package com.johar.mybatis.mybatistest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

@SpringBootApplication
@MapperScan(basePackages = {"com.johar.mybatis.mybatistest.mapper"})
public class MybatisTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisTestApplication.class, args);
    }

}
