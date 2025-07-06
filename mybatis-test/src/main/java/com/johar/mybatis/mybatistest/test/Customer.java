package com.johar.mybatis.mybatistest.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johar.mybatis.mybatistest.po.User;

/**
 * @ClassName: Customer
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/8/23 22:46
 * @Since: 1.0.0
 */
public class Customer {

    private String name;

    @JsonProperty("cname")
    public String getName() {
        return name;
    }

    @JsonProperty("ename")
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{ \"ename\": \"johar\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        Customer d = objectMapper.readValue(json, Customer.class);
        System.out.println(objectMapper.writeValueAsString(d));
    }
}