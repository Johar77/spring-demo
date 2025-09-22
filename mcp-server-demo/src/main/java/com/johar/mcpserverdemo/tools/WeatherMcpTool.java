package com.johar.mcpserverdemo.tools;

import com.google.common.collect.Maps;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/9/21 17:27]
 * @updateUser : [johar]
 * @updateTime : [2025/9/21 17:27]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Service
public class WeatherMcpTool {

    private final Map<String, String> weatherMap = Maps.newHashMap();
    {
        weatherMap.put("北京", "北京天气晴朗，温度23度");
        weatherMap.put("上海", "上海天气阴雨，温度18度");
        weatherMap.put("广州", "广州天气多云，温度25度");
        weatherMap.put("深圳", "深圳天气阴雨，温度20度");
    }

    @Tool(description = "Get weather information by city name")
    public String getWeather(@ToolParam(description = "City name") String city) {
        return weatherMap.getOrDefault(city, "暂无该城市的天气信息");
    }
}
