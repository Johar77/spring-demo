package com.johar.test.ruleengine.qlexpress4.bo;

import java.io.Serializable;
import java.util.Map;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/11/9 9:36]
 * @updateUser : [johar]
 * @updateTime : [2025/11/9 9:36]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class ActionBO implements Serializable {

    private String type;
    private Map<String, Object> params;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
