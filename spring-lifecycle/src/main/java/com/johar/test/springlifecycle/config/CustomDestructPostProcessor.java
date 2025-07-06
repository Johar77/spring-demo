package com.johar.test.springlifecycle.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CustomDestructPostProcessor
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 16:55
 * @Since: 1.0.0
 */
@Component
public class CustomDestructPostProcessor implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        //System.out.println("postProcessBeforeDestruction入参：" + beanName);
        if ("adminUser".equals(beanName)) {
            System.out.println("DestructionAwareBeanPostProcessor.postProcessBeforeDestruction");
        }
    }

    @Override
    public boolean requiresDestruction(Object bean) {
        //System.out.println("requiresDestruction入参：" + bean);
        if (bean instanceof AdminUser) {
            System.out.println("DestructionAwareBeanPostProcessor.requiresDestruction");
            return true;
        }
        return false;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("adminUser".equals(beanName)) {
            System.out.println("DestructionAwareBeanPostProcessor.postProcessBeforeInitialization");
        }
        //System.out.println("postProcessBeforeInitialization入参：" + beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("adminUser".equals(beanName)) {
            System.out.println("DestructionAwareBeanPostProcessor.postProcessAfterInitialization");
        }
        //System.out.println("postProcessAfterInitialization入参：" + beanName);
        return null;
    }
}