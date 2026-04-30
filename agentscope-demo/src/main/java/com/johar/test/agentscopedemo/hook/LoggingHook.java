package com.johar.test.agentscopedemo.hook;

import io.agentscope.core.hook.Hook;
import io.agentscope.core.hook.HookEvent;
import reactor.core.publisher.Mono;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/3/28 23:12]
 * @updateUser : [johar]
 * @updateTime : [2026/3/28 23:12]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class LoggingHook implements Hook {

    @Override
    public <T extends HookEvent> Mono<T> onEvent(T event) {
        System.out.println(event.getAgent().getAgentId() + " Agent " + event.getType() + " Hook: " + event.getAgent());
        return Mono.just( event);
    }
}
