package com.johar.mybatis.mybatistest.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

import java.io.IOException;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/1/6 23:30]
 * @updateUser : [johar]
 * @updateTime : [2026/1/6 23:30]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@RestControllerAdvice
@ControllerAdvice
@Slf4j
public class GlobalResponseErrorHandler {

    // 捕获客户端断开连接异常
    @ExceptionHandler(ClientAbortException.class)
    public String handleClientAbort(ClientAbortException e) {
        log.error("[全局异常] 客户端断开连接，响应发送失败", e);
        return "客户端连接异常"; // 注：此响应可能无法发给客户端（连接已断）
    }

    // 捕获IO异常（响应写入失败）
    @ExceptionHandler(IOException.class)
    public String handleIoException(IOException e) {
        log.error("[全局异常] 响应写入IO失败", e);
        return "服务器响应异常";
    }

    // 捕获异步请求超时
    @ExceptionHandler(AsyncRequestTimeoutException.class)
    public String handleAsyncTimeout(AsyncRequestTimeoutException e) {
        log.error("[全局异常] 异步请求（SSE）超时", e);
        return "请求超时";
    }

    // 捕获所有其他异常
    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception e) {
        log.error("[全局异常] 未知响应异常", e);
        return "服务器内部错误";
    }
}
