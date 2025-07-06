package com.johar.test.springlifecycle.config;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CustomSmartInitializingSingleton
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 17:26
 * @Since: 1.0.0
 */
@Component
public class CustomSmartInitializingSingleton implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("SmartInitializingSingleton.afterSingletonsInstantiated");
    }
}