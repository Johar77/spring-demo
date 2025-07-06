package com.johar.mybatis.mybatistest.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Properties;

/**
 * @ClassName: AutoInjectBaseFieldInterceptor
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/4/12 23:42
 * @Since: 1.0.0
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
@Component
@Slf4j
public class AutoInjectBaseFieldInterceptor implements Interceptor {



    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getArgs().length == 1) {
            return invocation.proceed();
        }

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];
        if (parameter == null) {
            return invocation.proceed();
        }
        if (SqlCommandType.UPDATE == sqlCommandType) {
            if (parameter instanceof MapperMethod.ParamMap) {
                MapperMethod.ParamMap<?> p = (MapperMethod.ParamMap<?>) parameter;
                if (p.containsKey("et")) {
                    parameter = p.get("et");
                } else {
                    parameter = p.get("param1");
                }
                if (parameter == null) {
                    return invocation.proceed();
                }
            }
            try {
                MetaObject metaObject = SystemMetaObject.forObject(parameter);
                String filedName = "updateTime";
                metaObject.setValue(filedName, new Date());
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}