package com.johar.common.commonbytecode.asm;

import java.lang.instrument.Instrumentation;

/**
 * @ClassName: PreMain
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/4 23:11
 * @Since: 1.0.0
 */
public class PreMain {

    /**
     * JVM 首先尝试在代理类上调用以下方法
     * @param agentArgs
     * @param instrumentation
     */
    public static void premain(String agentArgs, Instrumentation instrumentation){
        System.out.println("this is my agent：" + agentArgs);
        instrumentation.addTransformer(new ProfilingTransformer());
    }

    /**
     * 如果代理类没有实现上面的方法，那么JVM将尝试调用该方法
     * @param agentArgs
     */
    public static void premain(String agentArgs){

    }
}