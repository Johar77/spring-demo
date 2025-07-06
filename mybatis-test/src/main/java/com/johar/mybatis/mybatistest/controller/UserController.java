package com.johar.mybatis.mybatistest.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.johar.mybatis.mybatistest.dto.CreateUserDTO;
import com.johar.mybatis.mybatistest.po.Company;
import com.johar.mybatis.mybatistest.po.User;
import com.johar.mybatis.mybatistest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/2/9 00:02
 * @Since: 1.0.0
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{id}")
    public User getById(@PathVariable("id") int id){
        return userService.getById(id);
    }

    @GetMapping(path = "/all")
    public List<User> getById(){
        return userService.getAll();
    }

    @PostMapping(path = "/add")
    public User addUser(@Valid @RequestBody CreateUserDTO dto){
        return userService.add(dto);
    }

    @PostMapping(path = "/update")
    public User update(@RequestBody @Valid User dto){
        return userService.update(dto);
    }

//    public static void main(String[] args) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper = objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
//
//        User user = new User();
//        Company company = new Company();
//        company.setAddress("xxx");
//        company.setId(1);
//        company.setName("重庆");
//        user.setCompany(company);
//
//        String json = objectMapper.writeValueAsString(user);
//        System.out.println(json);
//    }

}