package com.johar.test.algorithm.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: StudentConfiguration
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/11 00:01
 * @Since: 1.0.0
 */
@Configuration
public class StudentConfiguration {

    @Autowired
    @Qualifier("student")
    private Student person;

    @Bean
    public Person newPerson(){
        person.name = "Anna1";
        return  person;
    }
}