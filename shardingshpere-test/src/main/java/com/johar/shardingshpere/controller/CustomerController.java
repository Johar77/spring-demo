package com.johar.shardingshpere.controller;

import com.johar.shardingshpere.model.Customer;
import com.johar.shardingshpere.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: CustomerController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/9/4 23:37
 * @Since: 1.0.0
 */
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/add")
    public void add(@RequestBody Customer customer){
        customerService.add(customer);
    }

    @GetMapping(path = "findAll")
    public List<Customer> findAll(){
        return customerService.selectAll();
    }

    @GetMapping(path = "{id}")
    public Customer findById(@PathVariable Integer id){
        return customerService.selectById(id);
    }
}