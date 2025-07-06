package com.johar.test.zookeeperdemo.dto;

/**
 * @ClassName: DataNode
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/16 23:31
 * @Since: 1.0.0
 */
public class DataNode {
    private String path;
    private Object data;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}