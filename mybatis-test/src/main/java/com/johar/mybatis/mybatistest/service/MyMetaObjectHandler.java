package com.johar.mybatis.mybatistest.service;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName: MyMetaObjectHandler
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/4/12 22:50
 * @Since: 1.0.0
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        String filedName = "createTime";
        this.strictInsertFill(metaObject, filedName, Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        String filedName = "updateTime";
        this.strictUpdateFill(metaObject, filedName, Date.class, new Date());
    }
}