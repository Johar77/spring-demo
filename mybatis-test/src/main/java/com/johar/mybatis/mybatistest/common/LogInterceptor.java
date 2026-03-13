package com.johar.mybatis.mybatistest.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/1/10 14:06]
 * @updateUser : [johar]
 * @updateTime : [2026/1/10 14:06]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Slf4j
public class LogInterceptor implements AsyncHandlerInterceptor {

    private final String interceptorInstanceId = UUID.randomUUID().toString().substring(0, 8);
    
    public LogInterceptor() {
        log.info("LogInterceptor 构造函数被调用，创建新实例，ID: {}", interceptorInstanceId);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查是否是异步请求的重复执行
        if (request.getAttribute("asyncStarted") != null) {
            // 异步请求的收尾阶段，跳过重复的preHandle
            log.info("【SSE拦截器-{}】preHandle执行 - asyncStarted:{}，response X-Trace-Id：{} ",
                    interceptorInstanceId, true, response.getHeader("X-Trace-Id"));
            return true;
        }

        String method = request.getMethod();
        String path = request.getRequestURI();
        String reqId = request.getHeader("X-Requested-Id");
        response.addHeader("X-Trace-Id", reqId);
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String sessionId = request.getSession(false) != null ? request.getSession().getId() : "None";
        
        log.info("【SSE拦截器-{}】preHandle执行 - 线程：{}，请求方法：{}，请求路径：{}，请求id：{}，远程地址：{}:{}，SessionId：{}", 
                interceptorInstanceId, Thread.currentThread().getName(), method, path, reqId, remoteHost, remotePort, sessionId);
        // 模拟鉴权：返回true允许继续
        return true;
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 标记异步处理已开始
        request.setAttribute("asyncStarted", true);
        
        String method = request.getMethod();
        String path = request.getRequestURI();
        String reqId = request.getHeader("X-Requested-Id");
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String sessionId = request.getSession(false) != null ? request.getSession().getId() : "None";
        
        log.info("【SSE拦截器-{}】afterConcurrentHandlingStarted执行 - 线程：{}，请求方法：{}，请求路径：{}，请求id：{}，远程地址：{}:{}，SessionId：{}", 
                interceptorInstanceId, Thread.currentThread().getName(), method, path, reqId, remoteHost, remotePort, sessionId);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String reqId = request.getHeader("X-Requested-Id");
        log.info("【SSE拦截器-{}】postHandle执行 - 线程：{}，请求id：{}", 
                interceptorInstanceId, Thread.currentThread().getName(), reqId);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            log.error("【SSE拦截器-{}】afterCompletion执行 - 异常：", interceptorInstanceId, ex);
        } else {
            log.info("【SSE拦截器-{}】afterCompletion执行 - SSE连接完全关闭，清理资源", interceptorInstanceId);
        }
        // 清理标记
        request.removeAttribute("asyncStarted");
    }
}
