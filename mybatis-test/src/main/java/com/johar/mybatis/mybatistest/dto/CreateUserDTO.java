package com.johar.mybatis.mybatistest.dto;

import com.johar.mybatis.mybatistest.annotations.InEnum;
import com.johar.mybatis.mybatistest.enums.GenderEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName: CreateUserDTO
 * @Author: Johar
 * @Date: 2024/3/16 12:05
 * @Since: 1.0.0
 */
@Data
public class CreateUserDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @Range(min = 0, max = 200, message = "年龄应该在0~200之间")
    private Integer age;

    //@NotNull(message = "性别不能为空")
    @InEnum(enumType = GenderEnum.class, message = "用户性别不在枚举范围内")
    private Integer sex;

    @NotNull(message = "公司id不能为空")
    private Integer companyId;
}