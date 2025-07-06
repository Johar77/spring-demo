package com.johar.test.zookeeperdemo.common;

/**
 * @ClassName: ErrorCodeEnum
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/20 17:01
 * @Since: 1.0.0
 */
public enum ErrorCodeEnum {
    SUCCESS(0, "success"),

    FAILED(-1, "failed"),

    ZOOKEEPER_ERROR(-100, "Zookeeper Error"),
    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
