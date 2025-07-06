package com.johar.test.eurekaclient.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.OperationNotSupportedException;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/2 23:20
 * @Since: 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(path = "getName")
    public String getName(){
        return "Johar";
    }

    @PostMapping(path = "error")
    public String createErr() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("not support");
    }
}