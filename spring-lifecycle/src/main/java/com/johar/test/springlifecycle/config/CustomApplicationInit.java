package com.johar.test.springlifecycle.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName: CustomApplicationInit
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 17:05
 * @Since: 1.0.0
 */
public class CustomApplicationInit implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer.initialize");
    }
}