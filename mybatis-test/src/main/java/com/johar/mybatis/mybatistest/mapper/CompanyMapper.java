package com.johar.mybatis.mybatistest.mapper;

import com.johar.mybatis.mybatistest.po.Company;

/**
 * @ClassName: CompanyMapper
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/2/11 10:09
 * @Since: 1.0.0
 */
public interface CompanyMapper {
    Company selectCompanyById(Integer id);
}
