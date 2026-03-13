package com.johar.mybatis.mybatistest.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/1/10 14:08]
 * @updateUser : [johar]
 * @updateTime : [2026/1/10 14:08]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有SSE请求
        LogInterceptor logInterceptor = new LogInterceptor();
        log.info("WebConfig.addInterceptors: 注册新的LogInterceptor实例，ID: {}", 
                 logInterceptor.getClass().getSimpleName());
        registry.addInterceptor(logInterceptor).addPathPatterns("/sse/**");
        //registry.addInterceptor(new AsyncLogInterceptor()).addPathPatterns("/sse/**");
    }
}
