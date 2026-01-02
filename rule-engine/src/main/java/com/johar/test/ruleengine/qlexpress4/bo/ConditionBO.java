package com.johar.test.ruleengine.qlexpress4.bo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/11/9 9:36]
 * @updateUser : [johar]
 * @updateTime : [2025/11/9 9:36]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleConditionBO.class, name = "condition"),
        @JsonSubTypes.Type(value = LogicConditionBO.class, name = "logic"),
        @JsonSubTypes.Type(value = CompositeConditionBO.class, name = "COMPOSITE")
})
public class ConditionBO implements Serializable {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
