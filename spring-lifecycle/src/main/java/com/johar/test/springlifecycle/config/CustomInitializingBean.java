package com.johar.test.springlifecycle.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CustomInitializingBean
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 17:26
 * @Since: 1.0.0
 */
@Component
public class CustomInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet");
    }
}