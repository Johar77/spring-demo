package com.johar.test.springlifecycle.config;

import com.johar.test.springlifecycle.dao.entity.UserEntity;
import com.johar.test.springlifecycle.dao.repository.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName: AdminUser
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 13:02
 * @Since: 1.0.0
 */
@Component
public class AdminUser implements DisposableBean, SmartLifecycle, ApplicationContextAware {

    @Autowired
    private UserMapper userMapper;

    private ApplicationContext applicationContext;
    private AtomicBoolean isRunning = new AtomicBoolean(false);


    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy");
    }


    @Override
    public void start() {
        System.out.println("Lifecycle.start");
        isRunning.set(true);
    }

    @Override
    public void stop() {
        System.out.println("Lifecycle.stop");
        System.out.println(userMapper.findById(1));
        isRunning.set(false);
    }

    @Override
    public boolean isRunning() {
        System.out.println("Lifecycle.isRunning");
        return isRunning.get();
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}