package com.johar.test.zookeeperdemo.common;

import ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName: ResponseControllerAdvice
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/21 00:43
 * @Since: 1.0.0
 */
@RestControllerAdvice
public class ResponseControllerAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        Class clazz = returnType.getParameterType();
        if (clazz.isAssignableFrom(BaseResult.class)){
            return false;
        } else if (clazz.isAssignableFrom(byte[].class)){
            return false;
        }

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (selectedContentType.equals(MediaType.APPLICATION_JSON)){
            return BaseResult.success(body);
        } else {
            return body;
        }
    }
}