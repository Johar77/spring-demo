package com.johar.test.zookeeperdemo.service;

import com.johar.test.zookeeperdemo.common.BaseResult;
import com.johar.test.zookeeperdemo.dto.DataNode;

/**
 * @ClassName: ZookeeperService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/14 16:40
 * @Since: 1.0.0
 */
public interface ZookeeperService {

    /**
     * 保存
     * @param dataNode
     * @return
     */
    BaseResult save(DataNode dataNode);

    /**
     * 删除
     * @param dataNode
     * @return
     */
    BaseResult remove(DataNode dataNode);

    /**
     * 获取数据
     * @param dataNode
     * @return
     */
    BaseResult getDataByPath(DataNode dataNode);

    /**
     * 获取子节点路径
     * @param dataNode
     * @return
     */
    BaseResult getChildByPath(DataNode dataNode);
}
