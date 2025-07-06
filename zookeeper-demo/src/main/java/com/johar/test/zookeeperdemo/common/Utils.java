package com.johar.test.zookeeperdemo.common;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName: Utils
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/16 23:55
 * @Since: 1.0.0
 */
@Slf4j
public class Utils {

    public static byte[] toByteArray(Object obj) {
        String str = JSON.toJSONString(obj);
        return str.getBytes(StandardCharsets.UTF_8);
    }
}