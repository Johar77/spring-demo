package com.johar.mybatis.mybatistest.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/1/2 21:41]
 * @updateUser : [johar]
 * @updateTime : [2026/1/2 21:41]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@RequestMapping("/custom/metric")
@RestController
public class CustomMetricController {

    // 注入MeterRegistry（SpringBoot自动配置）
    @Autowired
    private MeterRegistry meterRegistry;

    // 定义计数器：统计/hello接口调用次数
    private Counter helloRequestCounter;

    // 初始化自定义指标
    @PostConstruct
    public void initCustomMetrics() {
        helloRequestCounter = meterRegistry.counter(
                "custom.hello.request.count",  // 指标名（Prometheus中会转为snake_case）
                "agentId", "unknown"
        );
    }

    // 示例接口1：手动计数
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        // 每次调用计数器+1
        // helloRequestCounter.increment();
        meterRegistry.counter("custom.hello.request.count", "agentId", name).increment();
        return "Hello, " + name;
    }

    // 示例接口2：注解自动计时（统计请求耗时）
    @Timed(value = "custom.order.create.time", description = "创建订单接口耗时")
    @GetMapping("/create-order/{id}")
    public String createOrder(@PathVariable String id) throws InterruptedException {
        // 模拟业务耗时
        Thread.sleep(100);
        return "Order " + id + " created";
    }
}
