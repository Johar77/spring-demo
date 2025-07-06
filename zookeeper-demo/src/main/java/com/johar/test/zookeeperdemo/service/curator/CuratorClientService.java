package com.johar.test.zookeeperdemo.service.curator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.johar.test.zookeeperdemo.common.BaseResult;
import com.johar.test.zookeeperdemo.common.Utils;
import com.johar.test.zookeeperdemo.dto.DataNode;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: CuratorClientService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/21 10:46
 * @Since: 1.0.0
 */
@Service
@Slf4j
public class CuratorClientService {

    @Value("${zookeeper.host}")
    private String zookeeperHost;

    private CuratorFramework curatorClient;

    @PostConstruct
    public void init(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        curatorClient = CuratorFrameworkFactory.newClient(zookeeperHost, retryPolicy);
        curatorClient.start();
    }



    @SneakyThrows
    public void save(DataNode dataNode) {
        Stat stat = curatorClient.checkExists().forPath(dataNode.getPath());
        if (Objects.isNull(stat)) {
            curatorClient.create().creatingParentsIfNeeded().withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath(dataNode.getPath(), Utils.toByteArray(dataNode.getData()));
        }
    }


    @SneakyThrows
    public void remove(DataNode dataNode) {
        Stat stat = curatorClient.checkExists().forPath(dataNode.getPath());
        if (Objects.isNull(stat)){
            curatorClient.delete().forPath(dataNode.getPath());
        }
    }


    @SneakyThrows
    public Object getDataByPath(DataNode dataNode) {
        Stat stat = curatorClient.checkExists().forPath(dataNode.getPath());
        if (Objects.isNull(stat)){
            return null;
        }

        byte[] bytes = curatorClient.getData().forPath(dataNode.getPath());
        String json = new String(bytes, StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(json);
        return jsonObject;
    }


    @SneakyThrows
    public List<String> getChildByPath(DataNode dataNode) {
        Stat stat = curatorClient.checkExists().forPath(dataNode.getPath());
        if (Objects.isNull(stat)){
            return new ArrayList<>();
        }

        List<String> pathList = curatorClient.getChildren().forPath(dataNode.getPath());
        return pathList;
    }
}