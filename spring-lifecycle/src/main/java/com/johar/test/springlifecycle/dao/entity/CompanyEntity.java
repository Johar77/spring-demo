package com.johar.test.springlifecycle.dao.entity;

import lombok.Data;

/**
 * @ClassName: CompanyEntity
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 12:39
 * @Since: 1.0.0
 */
@Data
public class CompanyEntity {
    private int Id;

    private String name;

    private String address;
}