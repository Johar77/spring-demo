package com.johar.mybatis.mybatistest.common;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/1/7 0:00]
 * @updateUser : [johar]
 * @updateTime : [2026/1/7 0:00]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResponseWrapperFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 注入Request到包装类，方便日志排查
        ExceptionAwareResponseWrapper wrappedResponse = new ExceptionAwareResponseWrapper(req, resp);

        try {
            chain.doFilter(req, wrappedResponse);
            // 最后强制刷新一次（兜底）
            wrappedResponse.flushBuffer();
        } catch (Exception e) {
            // 捕获过滤器链中的异常，同步到包装类
            wrappedResponse.recordThrowable(e);
            throw e;
        }
    }
}

