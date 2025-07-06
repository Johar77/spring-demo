package com.johar.test.algorithm.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: PersonConfigration
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/10 23:59
 * @Since: 1.0.0
 */
@Configuration
public class PersonConfiguration {

    @Bean
    public Person person(){
        Person person = new Person();
        person.age = 12;
        person.name = "johar";
        return person;
    }

    @Bean
    public Student student(){
        Student student = new Student();
        student.name = "Anna";
        student.age = 24;
        return student;
    }
}