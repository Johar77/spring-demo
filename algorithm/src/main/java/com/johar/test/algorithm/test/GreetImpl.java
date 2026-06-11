package com.johar.test.algorithm.test;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/5/25 8:17]
 * @updateUser : [johar]
 * @updateTime : [2026/5/25 8:17]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class GreetImpl implements Greeting,GreetingPlus {


    public static void main(String[] args) {
        Greeting greeting = new GreetImpl();
        System.out.println(greeting.greet());
    }

    @Override
    public String greet() {
        return Greeting.super.greet();
    }
}
