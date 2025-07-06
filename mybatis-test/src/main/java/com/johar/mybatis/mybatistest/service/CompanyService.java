package com.johar.mybatis.mybatistest.service;

import com.johar.mybatis.mybatistest.mapper.CompanyMapper;
import com.johar.mybatis.mybatistest.po.Company;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: CompanyService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/3/16 15:23
 * @Since: 1.0.0
 */
@Service
@Validated
public class CompanyService implements ICompanyService{

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company selectCompanyById(Integer id) {
        return companyMapper.selectCompanyById(id);
    }
}