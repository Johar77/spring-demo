package com.johar.mybatis.mybatistest.controller;

import com.alibaba.fastjson.JSON;
import com.johar.mybatis.mybatistest.po.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: RedisController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/9/17 23:21
 * @Since: 1.0.0
 */
@RestController
@RequestMapping(path = "/redis")
public class RedisController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping(path = "/{key}")
    public String findByKey(@PathVariable("key") String key){
        return redisTemplate.opsForValue().get(key);
    }

    @PostMapping(path = "/save/{key}")
    public String save(@PathVariable("key") String key, @RequestBody Object body){
        String json = JSON.toJSONString(body);
        redisTemplate.opsForValue().set(key, json);
        return "success";
    }
}