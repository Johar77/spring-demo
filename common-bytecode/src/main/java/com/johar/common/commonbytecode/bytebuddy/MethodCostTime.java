package com.johar.common.commonbytecode.bytebuddy;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @ClassName: MethodCostTime
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/5 09:40
 * @Since: 1.0.0
 */
public class MethodCostTime {

    @RuntimeType
    public static Object intercept(@Origin Method method, @SuperCall
            Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return callable.call();
        } finally {
            System.out.println(method + " 方法耗时： " +
                    (System.currentTimeMillis() - start) + "ms");
        }
    }
}