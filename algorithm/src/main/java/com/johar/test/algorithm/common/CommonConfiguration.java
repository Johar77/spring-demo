package com.johar.test.algorithm.common;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: CommonConfiguration
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/11 00:04
 * @Since: 1.0.0
 */
//@Configuration
public class CommonConfiguration {

    //@Bean
    public Person customer(ObjectProvider<Person> personObjectProvider){
        Person p = personObjectProvider.getIfAvailable();
        System.out.println(p);
        return new Person();
    }
}