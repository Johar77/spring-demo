package com.johar.test.ruleengine.qlexpress4.bo;

import java.io.Serializable;
import java.util.List;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/11/9 9:35]
 * @updateUser : [johar]
 * @updateTime : [2025/11/9 9:35]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class RuleConfigBO implements Serializable {

    private String ruleCode;
    private String ruleName;
    private String ruleType;
    private int priority;
    private int status;
    private List<ConditionBO> conditions;
    private List<ActionBO> actions;

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ConditionBO> getConditions() {
        return conditions;
    }

    public void setConditions(List<ConditionBO> conditions) {
        this.conditions = conditions;
    }

    public List<ActionBO> getActions() {
        return actions;
    }

    public void setActions(List<ActionBO> actions) {
        this.actions = actions;
    }
}
