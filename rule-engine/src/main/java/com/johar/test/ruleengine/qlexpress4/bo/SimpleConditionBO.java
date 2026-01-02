package com.johar.test.ruleengine.qlexpress4.bo;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/11/9 9:43]
 * @updateUser : [johar]
 * @updateTime : [2025/11/9 9:43]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class SimpleConditionBO extends ConditionBO {
    private String field;
    private String operator;
    private Object value;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
