package com.johar.test.ruleengine.qlexpress4;

import com.alibaba.qlexpress4.runtime.Parameters;
import com.alibaba.qlexpress4.runtime.QContext;
import com.alibaba.qlexpress4.runtime.Value;
import com.alibaba.qlexpress4.runtime.function.CustomFunction;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/11/8 23:28]
 * @updateUser : [johar]
 * @updateTime : [2025/11/8 23:28]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class HelloFunction implements CustomFunction {


    @Override
    public Object call(QContext qContext, Parameters parameters) throws Throwable {
        List<Value> result = Lists.newArrayList();
        for (int i = 0; i < parameters.size(); i++) {
            result.add(parameters.get(i));
        }

        System.out.println("hello, " + result);
        return result;
    }
}
