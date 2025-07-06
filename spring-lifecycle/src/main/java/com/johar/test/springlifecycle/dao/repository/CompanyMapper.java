package com.johar.test.springlifecycle.dao.repository;

import com.johar.test.springlifecycle.dao.entity.CompanyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: CompanyMapper
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/7 12:57
 * @Since: 1.0.0
 */
@Mapper
public interface CompanyMapper {

    CompanyEntity findById(@Param("id") int id);
}
