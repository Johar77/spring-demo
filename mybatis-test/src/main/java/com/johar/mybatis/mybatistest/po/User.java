package com.johar.mybatis.mybatistest.po;

import java.util.Date;

/**
 * @ClassName: UserPO
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/2/8 23:18
 * @Since: 1.0.0
 */
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    private Date createTime;

    private Date updateTime;

    private Company company;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}