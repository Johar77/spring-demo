package com.johar.mybatis.mybatistest.annotations;

import com.johar.mybatis.mybatistest.enums.BasicEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName: InEnumValidator
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/3/16 16:02
 * @Since: 1.0.0
 */
public class InEnumValidator implements ConstraintValidator<InEnum, Object> {

    private Class<? extends BasicEnum> enumType;

    @Override
    public void initialize(InEnum inEnum) {
        enumType = inEnum.enumType();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) {
            return true;
        }

        if (enumType == null || !enumType.isEnum()) {
            return false;
        }

        for (BasicEnum basicEnum : enumType.getEnumConstants()) {
            if (basicEnum.getCode().equals(object)) {
                return true;
            }
        }
        return false;
    }
}