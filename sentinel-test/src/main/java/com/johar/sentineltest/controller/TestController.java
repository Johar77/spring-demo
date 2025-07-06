package com.johar.sentineltest.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/21 00:32
 * @Since: 1.0.0
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @GetMapping(value = "/1")
    @SentinelResource(value = "test1", blockHandler = "defaultBlockHandler", blockHandlerClass = BlockHandler.class)
    public String test1() {
        return "Hello,Sentinel --> 1";
    }

    @GetMapping(value = "/2")
    @SentinelResource(value = "test2", blockHandler = "defaultBlockHandler", blockHandlerClass = BlockHandler.class)
    public String test2() {
        return "Hello,Sentinel --> 2";
    }
}