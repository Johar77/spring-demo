package com.johar.test.algorithm.test;

public interface Greeting {
    default String greet(){
        return "Hello World, Greeting";
    }
}
