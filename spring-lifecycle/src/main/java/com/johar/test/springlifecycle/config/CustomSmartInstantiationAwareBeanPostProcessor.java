package com.johar.test.springlifecycle.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @ClassName: CustomSmartInstantiationAwareBeanPostProcessor
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 17:19
 * @Since: 1.0.0
 */
@Component
public class CustomSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        if ("adminUser".equals(beanName)) {
            System.out.println("SmartInstantiationAwareBeanPostProcessor.predictBeanType");
        }
        return null;
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        if ("adminUser".equals(beanName)) {
            System.out.println("SmartInstantiationAwareBeanPostProcessor.determineCandidateConstructors");
        }
        return null;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if ("adminUser".equals(beanName)) {
            System.out.println("SmartInstantiationAwareBeanPostProcessor.getEarlyBeanReference");
        }
        return bean;
    }
}