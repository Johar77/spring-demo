package com.johar.test.easyruletest.easyRule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

import java.io.FileReader;
import java.util.*;

/**
 * @ClassName: EasyRuleTest
 * @Description: TODO
 * @Author: Johar
 * @Date: 2022/6/18 12:23
 * @Since: 1.0.0
 */
public class EasyRuleTest {

    public static void main1(String[] args) throws Exception {
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rules rules = ruleFactory.createRules(new FileReader("E:\\Java\\workspace\\spring-demo\\easy-rule-test\\src\\main\\resources\\testRule.yml"));

        Person person = new Person();
        person.setAge(19);
        person.setName("张三");
        person.setSex(1);
        person.setHeight(180);

        Facts facts = new Facts();
        facts.put("person", person);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        Map<Rule, Boolean> result = rulesEngine.check(rules, facts);
        System.out.println("检测对象：" + person);
        System.out.println("检测结果：" + result);

        person.setAge(17);
        person.setSex(2);
        person.setHeight(166);
        result = rulesEngine.check(rules, facts);
        System.out.println("检测对象：" + person);
        System.out.println("检测结果：" + result);
    }

    public static void main(String[] args) throws Exception {
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rules rules = ruleFactory.createRules(new FileReader("E:\\Java\\workspace\\spring-demo\\easy-rule-test\\src\\main\\resources\\testRule.yml"));

        Person person = new Person();
        person.setAge(19);
        person.setName("张三");
        person.setSex(1);
        person.setHeight(180);

        Facts facts = new Facts();
        facts.put("person", person);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        Map<String, Boolean> result = groupCheck(rules, facts);
        System.out.println("检测对象：" + person);
        System.out.println("检测结果：" + result);

        person.setAge(17);
        person.setSex(2);
        person.setHeight(166);
        result = groupCheck(rules, facts);
        System.out.println("检测对象：" + person);
        System.out.println("检测结果：" + result);
    }

    public static Map<String, List<Rule>> convertGroupRule(Rules rules){
        Map<String, List<Rule>> ruleMap = new HashMap<>();
        for (Rule rule : rules) {
            List<Rule> ruleList = ruleMap.getOrDefault(rule.getName(), new ArrayList<>());
            ruleList.add(rule);
            ruleMap.put(rule.getName(), ruleList);
        }

        return ruleMap;
    }

    public static Map<String, Boolean> groupCheck(Rules rules, Facts facts){
        Map<String, Boolean> result = new HashMap<>();
        Map<String, List<Rule>> ruleMap = convertGroupRule(rules);
        for (Map.Entry<String, List<Rule>> entry : ruleMap.entrySet()){
            List<Rule> ruleList = entry.getValue();
            Boolean ok = null;
            for (Rule rule: ruleList){
                if (!rule.evaluate(facts)){
                    ok = Boolean.FALSE;
                    break;
                } else {
                    ok = Boolean.TRUE;
                }
            }

            result.put(entry.getKey(), ok);
        }

        return result;
    }
}