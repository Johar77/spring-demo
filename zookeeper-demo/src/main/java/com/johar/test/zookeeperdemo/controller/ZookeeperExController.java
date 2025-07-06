package com.johar.test.zookeeperdemo.controller;

import com.johar.test.zookeeperdemo.common.BaseResult;
import com.johar.test.zookeeperdemo.dto.DataNode;
import com.johar.test.zookeeperdemo.service.curator.CuratorClientService;
import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: ZookeeperExController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/21 11:28
 * @Since: 1.0.0
 */
@RestController
@RequestMapping("/zookeeperEx")
public class ZookeeperExController {

    @Autowired
    private CuratorClientService curatorClientService;

    @PostMapping(path = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody @Validated DataNode dataNode) throws KeeperException, InterruptedException {
        curatorClientService.save(dataNode);
    }

    @PostMapping(path = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void remove(@RequestBody @Validated DataNode dataNode) throws KeeperException, InterruptedException {
        curatorClientService.remove(dataNode);
    }

    @PostMapping(path = "/getDataByPath",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getDataByPath(@RequestBody @Validated DataNode dataNode) throws KeeperException, InterruptedException {
        return curatorClientService.getDataByPath(dataNode);
    }

    @PostMapping(path = "/getChildByPath",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getChildByPath(@RequestBody @Validated DataNode dataNode) throws KeeperException, InterruptedException {
        return curatorClientService.getChildByPath(dataNode);
    }
}