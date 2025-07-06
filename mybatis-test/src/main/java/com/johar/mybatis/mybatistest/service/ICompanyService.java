package com.johar.mybatis.mybatistest.service;

import com.johar.mybatis.mybatistest.po.Company;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: ICompanyService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/3/16 15:23
 * @Since: 1.0.0
 */
public interface ICompanyService {

    Company selectCompanyById(@Range(min = 0, message = "公司id不能小于0") Integer id);
}
