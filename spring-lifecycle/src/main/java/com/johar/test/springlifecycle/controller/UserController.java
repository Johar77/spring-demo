package com.johar.test.springlifecycle.controller;

import com.johar.test.springlifecycle.bo.UserBO;
import com.johar.test.springlifecycle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserContoller
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 12:40
 * @Since: 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{id}")
    public UserBO getUserById(@PathVariable(value = "id") int id){
        return userService.getUserById(id);
    }
}