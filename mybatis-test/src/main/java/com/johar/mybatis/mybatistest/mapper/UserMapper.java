package com.johar.mybatis.mybatistest.mapper;

import com.johar.mybatis.mybatistest.dto.CreateUserDTO;
import com.johar.mybatis.mybatistest.po.User;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/2/8 23:14
 * @Since: 1.0.0
 */
public interface UserMapper {

    User selectUserById(Integer id);

    List<User> getAll();

    void save(CreateUserDTO dto);

    int updateById(User user);
}
