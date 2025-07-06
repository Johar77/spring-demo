package com.johar.test.springlifecycle.dao.entity;

import lombok.Data;

/**
 * @ClassName: UserPO
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 12:25
 * @Since: 1.0.0
 */
@Data
public class UserEntity {

    private int id;

    private String name;

    private int age;

    /**
     * 0：未知；1：男性；2：女性
     */
    private int sex;

    private int companyId;
}