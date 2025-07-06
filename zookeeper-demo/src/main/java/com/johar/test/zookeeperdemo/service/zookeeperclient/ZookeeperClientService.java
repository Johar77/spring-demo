package com.johar.test.zookeeperdemo.service.zookeeperclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.johar.test.zookeeperdemo.common.BaseResult;
import com.johar.test.zookeeperdemo.common.Utils;
import com.johar.test.zookeeperdemo.dto.DataNode;
import com.johar.test.zookeeperdemo.service.ZookeeperService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: BasicOperateTest
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/14 15:26
 * @Since: 1.0.0
 */
@Service
@Slf4j
public class ZookeeperClientService implements ZookeeperService {

    @Value("${zookeeper.host}")
    private String zookeeperHost;

    private final static int sessionTimeout = 3000;
    @Autowired
    private BasicWatcher basicWatcher;
    private ZooKeeper zooKeeper;

    @PostConstruct
    public void init() throws Exception{
        this.zooKeeper = new ZooKeeper(zookeeperHost, sessionTimeout, basicWatcher);
        this.zooKeeper.addWatch("/", basicWatcher, AddWatchMode.PERSISTENT_RECURSIVE);
    }

    @SneakyThrows
    @Override
    public BaseResult save(DataNode dataNode)  {
        Stat stat = this.zooKeeper.exists(dataNode.getPath(), false);
        if (Objects.isNull(stat)){
            return BaseResult.success(this.zooKeeper.create(dataNode.getPath(), Utils.toByteArray(dataNode.getData()), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT));
        } else {
            return BaseResult.success(this.zooKeeper.setData(dataNode.getPath(), Utils.toByteArray(dataNode.getData()), stat.getVersion()));
        }
    }

    @SneakyThrows
    @Override
    public BaseResult remove(DataNode dataNode){
        Stat stat = this.zooKeeper.exists(dataNode.getPath(), false);
        if (Objects.isNull(stat)){
            return BaseResult.success();
        }

        this.zooKeeper.delete(dataNode.getPath(), stat.getVersion());
        return BaseResult.success();
    }

    @SneakyThrows
    @Override
    public BaseResult getDataByPath(DataNode dataNode)  {
        Stat stat = this.zooKeeper.exists(dataNode.getPath(), false);
        if (Objects.isNull(stat)){
            return BaseResult.success();
        }

        byte[] data = this.zooKeeper.getData(dataNode.getPath(), false, null);
        String content = new String(data, StandardCharsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(content);
        return BaseResult.success(jsonObject);
    }

    @SneakyThrows
    @Override
    public BaseResult getChildByPath(DataNode dataNode)  {
        Stat stat = this.zooKeeper.exists(dataNode.getPath(), false);
        if (Objects.isNull(stat)){
            return BaseResult.success();
        }

        List<String> childrenPath = this.zooKeeper.getChildren(dataNode.getPath(), false, null);
        return BaseResult.success(childrenPath);
    }
}