package com.johar.test.zookeeperdemo.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @ClassName: GlobalApplicationContext
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/14 16:06
 * @Since: 1.0.0
 */
@Component
public class GlobalApplicationContext implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Object getBean(String beanName) throws Exception{
        checkValid();
        return applicationContext.getBean(beanName);
    }

    private void checkValid() {
        if (Objects.isNull(applicationContext)){
            throw new IllegalArgumentException("applicationContext is null");
        }
    }

    public <T> T getBean(String name, Class<T> requiredType) throws BeansException{
        checkValid();
        return applicationContext.getBean(name, requiredType);
    }
}