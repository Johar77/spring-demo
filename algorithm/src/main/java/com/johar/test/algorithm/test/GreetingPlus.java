package com.johar.test.algorithm.test;

public interface GreetingPlus {
    default String greet(){
        return "Hello World, GreetingPlus";
    }
}
