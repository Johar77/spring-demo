package com.johar.mybatis.mybatistest.service;

import org.apache.ibatis.cache.decorators.BlockingCache;
import org.apache.ibatis.cache.impl.PerpetualCache;

/**
 * @ClassName: TestService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/6 23:43
 * @Since: 1.0.0
 */
public class TestService {

    public static void main(String[] args) {
        PerpetualCache perpetualCache = new PerpetualCache("1");
        BlockingCache cache = new BlockingCache(perpetualCache);

        System.out.println(cache.getObject("name"));
        cache.putObject("name", "johar");
        System.out.println(cache.getObject("name"));

    }
}