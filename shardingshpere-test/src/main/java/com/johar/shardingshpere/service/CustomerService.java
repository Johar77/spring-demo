package com.johar.shardingshpere.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johar.shardingshpere.mapper.CustomerMapper;
import com.johar.shardingshpere.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: CustomerService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/9/4 23:30
 * @Since: 1.0.0
 */
@Service
public class CustomerService extends ServiceImpl<CustomerMapper, Customer> {

    @Transactional(rollbackFor = Exception.class)
    public void add(Customer customer){
        customer.setCreateTime(new Date());
        baseMapper.insert(customer);
    }

    public Customer selectById(Integer id){
        Customer param = new Customer();
        param.setId(id);
        return baseMapper.selectById(param);
    }

    public List<Customer> selectAll(){
        LambdaQueryWrapper wrapper = new LambdaQueryWrapper();
        return baseMapper.selectList(wrapper);
    }
}