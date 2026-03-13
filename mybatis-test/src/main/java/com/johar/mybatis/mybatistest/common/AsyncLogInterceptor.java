package com.johar.mybatis.mybatistest.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/1/10 14:40]
 * @updateUser : [johar]
 * @updateTime : [2026/1/10 14:40]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Slf4j
public class AsyncLogInterceptor implements AsyncHandlerInterceptor {


    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String path = request.getRequestURI();
        String reqId = request.getHeader("X-Requested-Id");
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String sessionId = request.getSession(false) != null ? request.getSession().getId() : "None";

        log.info("【异步SSE拦截器】afterConcurrentHandlingStarted执行 - 请求方法：{}，请求路径：{}，请求id：{}，远程地址：{}:{}，SessionId：{}", method, path, reqId, remoteHost, remotePort, sessionId);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String path = request.getRequestURI();
        String reqId = request.getHeader("X-Requested-Id");
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String sessionId = request.getSession(false) != null ? request.getSession().getId() : "None";

        log.info("【异步SSE拦截器】preHandle执行 - 请求方法：{}，请求路径：{}，请求id：{}，远程地址：{}:{}，SessionId：{}", method, path, reqId, remoteHost, remotePort, sessionId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String method = request.getMethod();
        String path = request.getRequestURI();
        String reqId = request.getHeader("X-Requested-Id");
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String sessionId = request.getSession(false) != null ? request.getSession().getId() : "None";

        log.info("【异步SSE拦截器】postHandle执行 - 请求方法：{}，请求路径：{}，请求id：{}，远程地址：{}:{}，SessionId：{}", method, path, reqId, remoteHost, remotePort, sessionId);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String method = request.getMethod();
        String path = request.getRequestURI();
        String reqId = request.getHeader("X-Requested-Id");
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String sessionId = request.getSession(false) != null ? request.getSession().getId() : "None";

        log.info("【异步SSE拦截器】afterCompletion执行 - 请求方法：{}，请求路径：{}，请求id：{}，远程地址：{}:{}，SessionId：{}", method, path, reqId, remoteHost, remotePort, sessionId);
    }
}
