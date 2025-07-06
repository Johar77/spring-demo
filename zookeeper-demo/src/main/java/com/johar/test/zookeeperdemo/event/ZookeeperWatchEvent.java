package com.johar.test.zookeeperdemo.event;

import org.apache.zookeeper.WatchedEvent;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName: ZookeeperWatchEvent
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/14 16:15
 * @Since: 1.0.0
 */
public class ZookeeperWatchEvent extends ApplicationEvent {

    private WatchedEvent watchedEvent;


    public ZookeeperWatchEvent(WatchedEvent watchedEvent) {
        super(watchedEvent);
        this.watchedEvent = watchedEvent;
    }

    public WatchedEvent getWatchedEvent() {
        return watchedEvent;
    }

    public void setWatchedEvent(WatchedEvent watchedEvent) {
        this.watchedEvent = watchedEvent;
    }
}