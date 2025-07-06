package com.johar.common.commonbytecode.bytebuddy;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * @ClassName: PreMain
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/5 09:43
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
        AgentBuilder.Transformer transformer = (builder, typeDescription,
                                                classLoader, javaModule, protectionDomain) -> {
            return builder
                    .method(ElementMatchers.any()) // 拦截任意方法
                    .intercept(MethodDelegation.to(MethodCostTime.class));
        };
        AgentBuilder.Listener listener = new AgentBuilder.Listener(){
            @Override
            public void onDiscovery(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
                //System.out.println("onDiscovery: " + typeName);
            }

            @Override
            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded, DynamicType dynamicType) {
                //System.out.println("onTransformation: " + typeDescription.getName());
            }

            @Override
            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded) {
                //System.out.println("onDiscovery: " + typeDescription.getName());
            }

            @Override
            public void onError(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded, Throwable throwable) {
                //System.out.println("onDiscovery: " + typeName);
            }

            @Override
            public void onComplete(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
                //System.out.println("onDiscovery: " + typeName);
            }
        };

        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("com.johar.bytecode.bytecodedemo.service"))
                .transform(transformer)
                .with(listener)
                .installOn(instrumentation);
    }

    /**
     * 如果代理类没有实现上面的方法，那么JVM将尝试调用该方法
     * @param agentArgs
     */
    public static void premain(String agentArgs){

    }
}