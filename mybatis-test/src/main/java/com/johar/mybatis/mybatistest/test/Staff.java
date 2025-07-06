package com.johar.mybatis.mybatistest.test;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName: Staff
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/8/23 23:12
 * @Since: 1.0.0
 */
public class Staff {

    @JsonAlias({"bb", "cname"})
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{ \"bb\": \"johar\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Staff d = objectMapper.readValue(json, Staff.class);
        System.out.println(objectMapper.writeValueAsString(d));
    }
}