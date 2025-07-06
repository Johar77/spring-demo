package com.johar.mybatis.mybatistest.service;

import com.johar.mybatis.mybatistest.dto.CreateUserDTO;
import com.johar.mybatis.mybatistest.event.UserEvent;
import com.johar.mybatis.mybatistest.mapper.UserMapper;
import com.johar.mybatis.mybatistest.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/2/8 23:59
 * @Since: 1.0.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private ApplicationContext applicationContext;

    @Transactional(rollbackFor = Exception.class)
    public User getById(Integer id){
        User user = userMapper.selectUserById(id);
        applicationContext.publishEvent(new UserEvent(this));
        return user;
    }

    public List<User> getAll(){
        return userMapper.getAll();
    }

    public User add(CreateUserDTO dto) {
        companyService.selectCompanyById(dto.getCompanyId());
        userMapper.save(dto);
        return userMapper.selectUserById(dto.getId());
    }

    public User update(User user){
        userMapper.updateById(user);
        return userMapper.selectUserById(user.getId());
    }
}