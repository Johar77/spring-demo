package com.johar.test.springlifecycle.service;

import com.johar.test.springlifecycle.bo.UserBO;
import com.johar.test.springlifecycle.dao.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 12:42
 * @Since: 1.0.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserBO getUserById(int id){
        return userMapper.findById(id);
    }

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct");
    }
}