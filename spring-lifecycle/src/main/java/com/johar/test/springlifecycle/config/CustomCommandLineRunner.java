package com.johar.test.springlifecycle.config;

import com.johar.test.springlifecycle.dao.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CustomCommandLineRunner
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 17:27
 * @Since: 1.0.0
 */
@Component
public class CustomCommandLineRunner implements CommandLineRunner {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner.run");
        System.out.println(userMapper.findById(1));
    }
}