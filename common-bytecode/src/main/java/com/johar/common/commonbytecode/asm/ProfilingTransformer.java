package com.johar.common.commonbytecode.asm;

import javassist.*;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: ProfilingTransformer
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/3/4 23:24
 * @Since: 1.0.0
 */
public class ProfilingTransformer implements ClassFileTransformer {

    private static final Set<String> classNameSet = new HashSet<>();

    static {
        classNameSet.add("com.johar.bytecode.bytecodedemo.service.UserService");
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        String currentClassName = className.replaceAll("/", ".");
        if (!classNameSet.contains(currentClassName)) {
            return classfileBuffer;
        }

        System.out.println("transform: [" + currentClassName + "]");
        CtClass ctClass = null;
        try {
            ctClass = ClassPool.getDefault().get(currentClassName);
            CtBehavior[] methods = ctClass.getDeclaredBehaviors();
            for (CtBehavior method : methods) {
                enhanceMethod(method);
            }
            return ctClass.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classfileBuffer;
    }

    private void enhanceMethod(CtBehavior method) throws Exception {
        if (method.isEmpty()) {
            return;
        }
        String methodName = method.getName();
        if ("main".equalsIgnoreCase(methodName)) {
            return;
        }

        final StringBuilder source = new StringBuilder();
        source.append("{")
                .append("long start = System.nanoTime();\n")
                .append("$_ = $proceed($$);\n")
                .append("System.out.print(\"method:[")
                .append(methodName).append("]\");").append("\n")
                .append("System.out.println(\" cost:[\" +(System.nanoTime() - start)+ \"ns]\");")
                .append("}");
        ExprEditor editor = new ExprEditor() {
            @Override
            public void edit(MethodCall methodCall) throws
                    CannotCompileException {
                methodCall.replace(source.toString());
            }
        };
        method.instrument(editor);
    }
}