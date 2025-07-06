package com.johar.bytecode.bytecodedemo.service;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/4 23:05
 * @Since: 1.0.0
 */
public class UserService {

    public String findById(Long id){
        return "Johar";
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.findById(1L);
    }
}