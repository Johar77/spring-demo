package com.johar.test.zookeeperdemo.service.zookeeperclient;

import cn.hutool.json.JSONUtil;
import com.johar.test.zookeeperdemo.event.ZookeeperWatchEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BasicWatcher
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/14 15:38
 * @Since: 1.0.0
 */
@Component
@Slf4j
public class BasicWatcher implements Watcher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void process(WatchedEvent event) {
        log.info("receive event: {}", event);
        applicationEventPublisher.publishEvent(new ZookeeperWatchEvent(event));
    }
}