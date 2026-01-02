package com.johar.test.ruleengine.qlexpress4;

import com.alibaba.qlexpress4.Express4Runner;
import com.alibaba.qlexpress4.InitOptions;
import com.alibaba.qlexpress4.QLOptions;
import com.alibaba.qlexpress4.QLResult;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/11/9 9:57]
 * @updateUser : [johar]
 * @updateTime : [2025/11/9 9:57]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class RuleParaseDemo {

    public static void main(String[] args) throws Exception {
        // 读取 resources 目录下的 rule.json 文件
        InputStream inputStream = RuleParaseDemo.class.getClassLoader().getResourceAsStream("rule.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder jsonString = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonString.append(line);
        }

        RuleParaseUtils.executeRule(jsonString.toString());

        Map<String, Object> contextData = new HashMap<>();
        contextData.put("userLevel", "VIP");        // 用户等级
        contextData.put("orderAmount", 120.0);      // 订单金额
        contextData.put("productCategory", "electronics"); // 商品类别
        String rule = "function action_discount(discountRate) {return discountRate;} \n" +
                "if (((userLevel == 'VIP' or orderAmount >= 100) and (productCategory == 'electronics' or productCategory == 'clothing'))) { \n" +
                "    action_discount(orderAmount); \n" +
                "}";
        Express4Runner express4Runner = new Express4Runner(InitOptions.builder().traceExpression(true).build());
        QLResult result = express4Runner.execute(rule, contextData, QLOptions.builder().traceExpression(true).build());
        System.out.println(result.getResult());

        String rule1 = "(userLevel == 'VIP' or orderAmount >= 100) and (productCategory == 'electronics' or productCategory == 'clothing')";
        QLResult result1 = express4Runner.execute(rule1, contextData, QLOptions.DEFAULT_OPTIONS);
        System.out.println(result1.getResult());
    }
}
