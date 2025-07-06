package com.johar.shardingshpere.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.johar.shardingshpere.model.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: CustomerMapper
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/9/4 23:28
 * @Since: 1.0.0
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
