package com.johar.test.openfeigntest.controller;

import com.johar.test.openfeigntest.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/2 23:28
 * @Since: 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserClient userClient;

    @PostMapping(path = "/getUser")
    public Object getUser(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1L);
        map.put("age", 30);
        map.put("sex", "男");
        String name = userClient.getName();
        map.put("name", name);
        return map;
    }

    @PostMapping(path = "/error")
    public Object createError() throws OperationNotSupportedException {
        return userClient.createErr();
    }
}