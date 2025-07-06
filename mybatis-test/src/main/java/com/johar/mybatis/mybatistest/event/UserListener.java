package com.johar.mybatis.mybatistest.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: UserListener
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/12/3 22:48
 * @Since: 1.0.0
 */
@Component
public class UserListener {

    @EventListener
    public void onEvent(UserEvent userEvent){
        boolean flag = true;
        if (!flag){
            throw new IllegalArgumentException("测试");
        }
    }
}