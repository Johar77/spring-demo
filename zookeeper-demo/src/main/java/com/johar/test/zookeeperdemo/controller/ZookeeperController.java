package com.johar.test.zookeeperdemo.controller;

import com.johar.test.zookeeperdemo.common.BaseResult;
import com.johar.test.zookeeperdemo.dto.DataNode;
import com.johar.test.zookeeperdemo.service.curator.CuratorClientService;
import com.johar.test.zookeeperdemo.service.zookeeperclient.ZookeeperClientService;
import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ZookeeperController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/14 16:35
 * @Since: 1.0.0
 */
@RestController
@RequestMapping("/zookeeper")
public class ZookeeperController {

    @Autowired
    private ZookeeperClientService zookeeperClientService;


    @PostMapping(path = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResult save(@RequestBody @Validated DataNode dataNode) throws KeeperException, InterruptedException {
        return zookeeperClientService.save(dataNode);
    }

    @PostMapping(path = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResult remove(@RequestBody @Validated DataNode dataNode) throws KeeperException, InterruptedException {
        return zookeeperClientService.remove(dataNode);
    }

    @PostMapping(path = "/getDataByPath",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResult getDataByPath(@RequestBody @Validated DataNode dataNode) throws KeeperException, InterruptedException {
        return zookeeperClientService.getDataByPath(dataNode);
    }

    @PostMapping(path = "/getChildByPath",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResult getChildByPath(@RequestBody @Validated DataNode dataNode) throws KeeperException, InterruptedException {
        return zookeeperClientService.getChildByPath(dataNode);
    }
}