package com.johar.shardingshpere.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Customer
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/9/4 23:20
 * @Since: 1.0.0
 */
@TableName(value = "t_customer")
@Data
public class Customer implements Serializable {
    private final static long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String idCard;

    private String userName;

    private Integer age;

    private Date createTime;
}