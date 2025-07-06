package com.johar.mybatis.mybatistest.annotations;

import com.johar.mybatis.mybatistest.enums.BasicEnum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: InEnum
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/3/16 16:01
 * @Since: 1.0.0
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InEnumValidator.class)
public @interface InEnum {

    /**
     * 枚举类型
     *
     * @return
     */
    Class<? extends BasicEnum> enumType();

    String message() default "枚举类型不匹配";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
