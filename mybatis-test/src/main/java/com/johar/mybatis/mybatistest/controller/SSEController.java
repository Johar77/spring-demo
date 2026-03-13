package com.johar.mybatis.mybatistest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/1/10 13:27]
 * @updateUser : [johar]
 * @updateTime : [2026/1/10 13:27]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@RequestMapping("/sse")
@RestController
@Slf4j
public class SSEController {
    private final ExecutorService sseExecutor = Executors.newFixedThreadPool(10);

    @GetMapping("/basic")
    public SseEmitter sseBasic() {
        // 1. 创建SseEmitter，设置超时时间（30秒，0表示永不超时）
        // 对于一次性推送，设置较短的超时时间，避免客户端自动重连
        SseEmitter emitter = new SseEmitter(0L); // 0表示永不超时，由服务器主动关闭

        // 2. 异步推送消息（必须异步，否则阻塞Controller线程）
        sseExecutor.submit(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    // 推送消息：SseEmitter.event()可自定义事件、数据、ID
                    emitter.send(SseEmitter.event()
                            .id(String.valueOf(i)) // 消息ID（客户端可通过lastEventId重连）
                            .name("message") // 自定义事件类型（客户端需对应监听）
                            .data("这是第" + (i + 1) + "条推送消息")); // 推送数据（支持字符串/JSON）

                    // 模拟1秒推送一次
                    Thread.sleep(1000);
                }

                // 3. 推送完成，发送关闭消息
                emitter.send(SseEmitter.event()
                        .name("close")
                        .data("所有消息推送完成，连接即将关闭"));

                // 4. 延迟关闭，给客户端时间处理
                // Thread.sleep(1000);

                // 5. 主动关闭连接
                emitter.complete();
                log.info("SSE连接正常关闭");

            } catch (IOException e) {
                // 客户端主动断开连接时触发（如关闭页面）
                log.error("客户端主动断开SSE连接", e);
                emitter.completeWithError(e);
            } catch (InterruptedException e) {
                log.error("SSE推送线程被中断", e);
                emitter.completeWithError(e);
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                // 其他异常：关闭连接并传递异常
                log.error("SSE推送异常", e);
                emitter.completeWithError(e);
            }
        });

        // 4. 注册超时回调
        emitter.onTimeout(() -> {
            log.warn("SSE连接超时");
            emitter.complete();
        });

        // 5. 注册完成回调（无论正常/异常关闭，都会执行）
        emitter.onCompletion(() -> {
            log.info("SSE连接完成（资源释放）");
            // 释放资源：如从缓存中移除emitter
        });
        emitter.onError(e -> {
            log.error("SSE连接异常", e);
            emitter.completeWithError(e);
        });

        return emitter;
    }
}
