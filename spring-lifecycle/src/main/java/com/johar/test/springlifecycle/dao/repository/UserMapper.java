package com.johar.test.springlifecycle.dao.repository;

import com.johar.test.springlifecycle.bo.UserBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.johar.test.springlifecycle.dao.entity.UserEntity;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 12:28
 * @Since: 1.0.0
 */
@Mapper
public interface UserMapper {

    /**
     * 单个添加用户数据
     * @param userEntity
     * @return 修改记录条数
     */
    int insert(@Param("userEntity")  UserEntity userEntity);

    /**
     * 批量添加用户信息
     * @param userEntityList
     * @return
     */
    int batchInsert(@Param("userList") List<UserEntity> userEntityList);

    /**
     * 根据用户名精确查看用户
     * @param name
     * @return
     */
    UserEntity findByName(@Param("name") String name);

    /**
     * 根据用户名、年龄范围分页查询用户信息
     * @param name
     * @param minAge
     * @param maxAge
     * @return
     */
    List<UserEntity> findWithPage(@Param("name") String name, @Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

    /**
     * 根据id查询用户
     * @param id id
     * @return 用户
     */
    UserBO findById(@Param("id") int id);
}
