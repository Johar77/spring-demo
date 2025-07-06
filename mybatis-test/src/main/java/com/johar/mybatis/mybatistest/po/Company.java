package com.johar.mybatis.mybatistest.po;

import org.apache.ibatis.annotations.Update;

/**
 * @ClassName: Company
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/2/8 23:18
 * @Since: 1.0.0
 */
public class Company {
    private Integer id;

    private String name;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}