package com.johar.test.zookeeperdemo.common;

/**
 * @ClassName: BaseResult
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/16 23:23
 * @Since: 1.0.0
 */
public class BaseResult<T> {

    private Integer code;
    private String message;
    private T data;

    public BaseResult() {
    }

    public BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> BaseResult success(T data){
        BaseResult result = new BaseResult<T>(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMessage(), data);
        return result;
    }

    public static <T> BaseResult success(){
        return BaseResult.success(null);
    }

    public static <T> BaseResult failed(Integer code, String message){
        BaseResult result = new BaseResult<T>(code, message, null);
        return result;
    }

    public static <T> BaseResult failed(ErrorCodeEnum errorCodeEnum){
        return BaseResult.failed(errorCodeEnum.getCode(), errorCodeEnum.getMessage());
    }
}