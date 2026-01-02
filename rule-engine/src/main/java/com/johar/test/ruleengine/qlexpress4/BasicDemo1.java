package com.johar.test.ruleengine.qlexpress4;

import com.alibaba.qlexpress4.Express4Runner;
import com.alibaba.qlexpress4.InitOptions;
import com.alibaba.qlexpress4.QLOptions;
import com.alibaba.qlexpress4.QLResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/11/8 23:12]
 * @updateUser : [johar]
 * @updateTime : [2025/11/8 23:12]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class BasicDemo1 {

    public static void main(String[] args) {
        Express4Runner express4Runner = new Express4Runner(InitOptions.builder().traceExpression(true).build());
        Map<String, Object> context = new HashMap<>();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        QLResult calcResult = express4Runner.execute("a + b * c", context, QLOptions.builder().traceExpression(true).build());
        System.out.println(calcResult.getResult());
        System.out.println(calcResult.getExpressionTraces());

        // custom function
        express4Runner.addVarArgsFunction("join",
                params -> Arrays.stream(params).map(Object::toString).collect(Collectors.joining(",")));
        Object resultFunction =
                express4Runner.execute("join(1,2,3)", Collections.emptyMap(), QLOptions.DEFAULT_OPTIONS).getResult();
        System.out.println(resultFunction);

        // custom operator
        express4Runner.addOperatorBiFunction("join", (left, right) -> left + "," + right);
        Object resultOperator =
                express4Runner.execute("1 join 2 join 3", Collections.emptyMap(), QLOptions.DEFAULT_OPTIONS).getResult();
        System.out.println(resultOperator);

        express4Runner.addFunction("hello", new HelloFunction());
        QLResult resultFunction2 =
                express4Runner.execute("hello(1,2,3)", Collections.emptyMap(), QLOptions.builder().traceExpression(true).build());
        System.out.println(resultFunction2.getResult());
        System.out.println(resultFunction2.getExpressionTraces());
    }
}
