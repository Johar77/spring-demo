package com.johar.test.ruleengine.qlexpress4;

import com.alibaba.qlexpress4.Express4Runner;
import com.alibaba.qlexpress4.InitOptions;
import com.alibaba.qlexpress4.QLOptions;
import com.alibaba.qlexpress4.QLResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.johar.test.ruleengine.qlexpress4.bo.*;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/11/9 9:45]
 * @updateUser : [johar]
 * @updateTime : [2025/11/9 9:45]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */

public class RuleParaseUtils {

    public static void executeRule(String jsonRule) throws Exception {
        // 2. 解析 JSON 规则配置
        RuleConfigBO ruleConfig = parseRuleConfig(jsonRule);

        // 3. 检查规则状态（仅启用的规则才执行）
        if (ruleConfig.getStatus() != 1) {
            System.out.println("规则已禁用: " + ruleConfig.getRuleName());
            return;
        }

        // 4. 准备执行参数（业务数据）
        Map<String, Object> contextData = new HashMap<>();
        contextData.put("userLevel", "VIP");        // 用户等级
        contextData.put("orderAmount", 120.0);      // 订单金额
        contextData.put("productCategory", "electronics"); // 商品类别

        // 5. 将规则条件转换为 QLExpress 表达式
        String conditionExpression = convertConditionsToQLExpress(ruleConfig.getConditions());
        System.out.println("QLExpress 条件表达式: " + conditionExpression);

        // 6. 构建完整的 QLExpress 脚本
        String qlExpressScript = buildQLExpressScript(conditionExpression, ruleConfig.getActions());
        System.out.println("QLExpress 脚本: " + qlExpressScript);

        // 7. 执行规则
        executeRule(qlExpressScript, contextData);
    }

    private static RuleConfigBO parseRuleConfig(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, RuleConfigBO.class);
    }

    /**
     * 将条件表达式转换为 QLExpress 表达式
     */
    private static String convertConditionsToQLExpress(List<ConditionBO> conditions) {
        if (CollectionUtils.isEmpty(conditions)) {
            return "true";
        }

        // 处理第一个条件（可能有嵌套）
        return convertCondition(conditions.get(0));
    }

    private static String convertCondition(ConditionBO condition) {
        if (condition instanceof SimpleConditionBO) {
            SimpleConditionBO simpleCond = (SimpleConditionBO) condition;
            String valueStr = formatValue(simpleCond.getValue());
            String operator = convertOperator(simpleCond.getOperator());
            return String.format("%s %s %s",
                    simpleCond.getField(),
                    operator,
                    valueStr);
        } else if (condition instanceof LogicConditionBO) {
            return ((LogicConditionBO) condition).getOperator().toLowerCase();
        } else if (condition instanceof CompositeConditionBO) {
            CompositeConditionBO compCond = (CompositeConditionBO) condition;
            List<String> subConditions = compCond.getExpressions().stream()
                    .map(RuleParaseUtils::convertCondition)
                    .collect(Collectors.toList());

            // 嵌套条件需要括号
            String joinedConditions = String.join(" ", subConditions);
            return "(" + joinedConditions + ")";
        }
        return "true";
    }

    private static String formatValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Number) {
            return value.toString();
        }
        return value.toString();
    }

    private static String convertOperator(String operator) {
        switch (operator) {
            case "EQUAL":
                return "==";
            case "GREATER_THAN_OR_EQUAL":
                return ">=";
            case "LESS_THAN":
                return "<";
            case "CONTAINS":
                return "contains";
            default:
                throw new IllegalArgumentException("不支持的操作符: " + operator);
        }
    }

    /**
     * 构建 QLExpress 脚本
     */
    private static String buildQLExpressScript(String conditionExpression, List<ActionBO> actions) {
        // 定义所有动作函数
        StringBuilder functionDefs = new StringBuilder();
        for (int i = 0; i < actions.size(); i++) {
            ActionBO action = actions.get(i);
            functionDefs.append(generateActionFunction(action, i));
        }

        // 构建主逻辑
        return functionDefs.toString() +
                "if (" + conditionExpression + ") {" +
                "  " + actions.stream()
                .map(action -> "action_" + action.getType().toLowerCase())
                .collect(Collectors.joining("; ")) +
                ";};";
    }

    private static String generateActionFunction(ActionBO action, int index) {
        String functionName = "action_" + action.getType().toLowerCase();
        String params = action.getParams().entrySet().stream()
                .map(e -> e.getKey() + ": " + formatValue(e.getValue()))
                .collect(Collectors.joining(", "));

        // 根据动作类型生成函数体
        String body;
        switch (action.getType()) {
            case "DISCOUNT":
                body = "System.out.println(\"应用折扣: \" + discountRate + \" 折\");" +
                        "return discountRate;";
                break;
            case "MESSAGE":
                body = "System.out.println(\"消息: \" + message);";
                break;
            default:
                body = "System.out.println(\"未知动作: \" + \"" + action.getType() + "\");";
        }

        return "function " + functionName + "(discountRate, message) {" +
                body +
                "} ";
    }

    /**
     * 执行 QLExpress 规则
     */
    private static void executeRule(String script, Map<String, Object> contextData) {
        try {
            // 创建执行上下文
            Map<String, Object> context = Maps.newHashMap();
            for (Map.Entry<String, Object> entry : contextData.entrySet()) {
                context.put(entry.getKey(), entry.getValue());
            }

            // 创建表达式运行器
            Express4Runner runner = new Express4Runner(InitOptions.DEFAULT_OPTIONS);

            // 执行规则
            System.out.println("\n执行规则...");
            QLResult result = runner.execute(script, context, QLOptions.DEFAULT_OPTIONS);

            System.out.println("规则执行结果: " + result.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
