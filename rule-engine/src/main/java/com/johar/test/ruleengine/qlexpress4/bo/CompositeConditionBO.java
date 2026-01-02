package com.johar.test.ruleengine.qlexpress4.bo;

import java.util.List;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/11/9 9:50]
 * @updateUser : [johar]
 * @updateTime : [2025/11/9 9:50]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class CompositeConditionBO extends ConditionBO {

    private List<ConditionBO> expressions;

    public List<ConditionBO> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<ConditionBO> expressions) {
        this.expressions = expressions;
    }
}
