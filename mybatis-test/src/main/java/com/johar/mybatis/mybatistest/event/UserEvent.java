package com.johar.mybatis.mybatistest.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName: UserEvent
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/12/3 22:46
 * @Since: 1.0.0
 */
public class UserEvent extends ApplicationEvent {

    public UserEvent(Object source) {
        super(source);
    }
}