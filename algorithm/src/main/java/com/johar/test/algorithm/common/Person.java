package com.johar.test.algorithm.common;

/**
 * @ClassName: Person
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/7 22:55
 * @Since: 1.0.0
 */
public class Person {

    public int age;

    public String name;

    private long id;

    public static void doTask(){
        System.out.println("person do task");
    }

    private void dowork(){
        System.out.println("person do work");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}