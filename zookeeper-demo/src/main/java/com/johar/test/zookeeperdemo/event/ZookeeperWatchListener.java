package com.johar.test.zookeeperdemo.event;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ZookeeperWatchListener
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/14 16:17
 * @Since: 1.0.0
 */
@Component
@Slf4j
public class ZookeeperWatchListener implements ApplicationListener<ZookeeperWatchEvent> {


    @Override
    public void onApplicationEvent(ZookeeperWatchEvent event) {
        log.info("begin handler zookeeper event: {}", event);
        // todo 处理逻辑
        log.info("end handler zookeeper event: {}", event);
    }
}