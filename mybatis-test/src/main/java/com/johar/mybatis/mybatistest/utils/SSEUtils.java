package com.johar.mybatis.mybatistest.utils;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/1/10 13:30]
 * @updateUser : [johar]
 * @updateTime : [2026/1/10 13:30]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class SSEUtils {

    private Map<String, SseEmitter> emitterMap = new ConcurrentHashMap<>();

    public void addEmitter(String id, SseEmitter emitter) {
        emitterMap.put(id, emitter);
    }

    public void removeEmitter(String id) {
        emitterMap.remove(id);
    }
}
