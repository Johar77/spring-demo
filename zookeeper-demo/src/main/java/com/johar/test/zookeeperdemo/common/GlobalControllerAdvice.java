package com.johar.test.zookeeperdemo.common;

import org.apache.zookeeper.KeeperException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalControllerAdvice
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/8/20 16:59
 * @Since: 1.0.0
 */
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = KeeperException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResult zookeeperExceptionHandler(KeeperException e){
        return BaseResult.failed(ErrorCodeEnum.ZOOKEEPER_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResult exceptionHandler(Exception e){
        return BaseResult.failed(ErrorCodeEnum.FAILED.getCode(), e.getMessage());
    }
}