package com.johar.mybatis.mybatistest.enums;

/**
 * @ClassName: GenderEnum
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/3/16 15:59
 * @Since: 1.0.0
 */
public enum GenderEnum implements BasicEnum {
    MALE(1, "男"),
    FEMALE(2, "女"),
    ;
    private Integer code;
    private String desc;

    GenderEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
