package com.johar.test.easyruletest.easyRule;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @ClassName: Person
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/6/18 12:21
 * @Since: 1.0.0
 */
@Data
public class Person {
    /**
     * 年龄
     */
    private int age;
    /**
     * 姓名
     */
    private String name;
    /**
     * 是否成年
     */
    private boolean adult;
    /**
     * 性别，1：男，2：女，0：未知
     */
    private int sex;
    /**
     * 身高，单位：cmHttpEntity
     */
    private int height;

    public static void main(String[] args) {
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        serializer.setObjectMapper(om);

        Person baseBO = new Person();
        byte[] data = serializer.serialize(baseBO);
        String string = new String(data);
        System.out.println(string);
    }
}