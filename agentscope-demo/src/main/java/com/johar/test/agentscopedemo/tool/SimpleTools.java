package com.johar.test.agentscopedemo.tool;

import io.agentscope.core.message.ToolResultBlock;
import io.agentscope.core.tool.Tool;
import io.agentscope.core.tool.ToolEmitter;
import io.agentscope.core.tool.ToolParam;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/3/28 17:19]
 * @updateUser : [johar]
 * @updateTime : [2026/3/28 17:19]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */

public class SimpleTools {

    @Tool(name = "get_time", description = "获取当前时间")
    public String getTime(
            @ToolParam(name = "zone", description = "时区，例如：北京") String zone) {
        return LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Tool(description = "获取指定城市的天气")
    public String getWeather(
            @ToolParam(name = "city", description = "城市名称") String city) {
        return city + " 的天气：晴天，25°C";
    }

    @Tool(description = "计算两数之和")
    public int add(
            @ToolParam(name = "a", description = "第一个数") int a,
            @ToolParam(name = "b", description = "第二个数") int b) {
        return a + b;
    }

//    @Tool(description = "异步搜索")
//    public Mono<String> search(
//            @ToolParam(name = "query", description = "搜索词") String query) {
//        return webClient.get()
//                .uri("/search?q=" + query)
//                .retrieve()
//                .bodyToMono(String.class);
//    }

    @Tool(description = "生成数据")
    public ToolResultBlock generate(
            @ToolParam(name = "count") int count,
            ToolEmitter emitter) {  // 自动注入，无需 @ToolParam
        for (int i = 0; i < count; i++) {
            emitter.emit(ToolResultBlock.text("进度 " + i));
        }
        return ToolResultBlock.text("完成");
    }
}
