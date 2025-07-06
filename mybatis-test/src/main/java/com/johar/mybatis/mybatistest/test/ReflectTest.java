package com.johar.mybatis.mybatistest.test;

import com.johar.mybatis.mybatistest.po.User;
import org.apache.ibatis.reflection.Reflector;

/**
 * @ClassName: ReflectTest
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/2/28 00:06
 * @Since: 1.0.0
 */
public class ReflectTest {

    public static void main(String[] args) {
        Reflector reflector = new Reflector(User.class);
        System.out.println(reflector.getGetablePropertyNames());
        System.out.println(reflector.getSetablePropertyNames());

        Reflector reflector1 = new Reflector(User.class);
        System.out.println(reflector1.getGetablePropertyNames());
        System.out.println(reflector1.getSetablePropertyNames());
    }
}