package com.johar.sentineltest.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @ClassName: BlockHandler
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/21 12:18
 * @Since: 1.0.0
 */
@Slf4j
public class BlockHandler {

    public static String defaultBlockHandler(BlockException e){
        log.error("熔断降级处理：{}", printBlockException(e));
        return "熔断降级处理";
    }

    private static String printBlockException(BlockException e){
        if (Objects.isNull(e) || Objects.isNull(e.getRule())){
            return null;
        }

        return "资源名称：" + e.getRule().getResource();
    }
}