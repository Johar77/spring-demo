package com.johar.test.springlifecycle.bo;

import com.johar.test.springlifecycle.dao.entity.CompanyEntity;
import lombok.Data;

/**
 * @ClassName: UserBO
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 12:35
 * @Since: 1.0.0
 */
@Data
public class UserBO {
    private int id;

    private String name;

    private int age;

    /**
     * 0：未知；1：男性；2：女性
     */
    private int sex;

    private CompanyEntity company;
}