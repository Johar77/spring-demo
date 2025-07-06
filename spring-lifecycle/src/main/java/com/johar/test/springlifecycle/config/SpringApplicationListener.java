package com.johar.test.springlifecycle.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SpringApplicationListener
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 17:28
 * @Since: 1.0.0
 */
@Component
public class SpringApplicationListener {

    @EventListener
    public void handler(ApplicationEvent event){
        System.out.println("EventListener: " + event);
    }
}