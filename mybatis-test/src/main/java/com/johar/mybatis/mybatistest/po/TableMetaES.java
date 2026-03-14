package com.johar.mybatis.mybatistest.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/3/10 23:32]
 * @updateUser : [johar]
 * @updateTime : [2026/3/10 23:32]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Data
@ToString(callSuper = true)
public class TableMetaES extends TableMetaBase {

    @JSONField(unwrapped = true, serialize = true, deserialize = true)
    private Map<String, List<Float>> vectorFields = new HashMap<>();

    @JsonAnyGetter
    public Map<String, List<Float>> getVectorFields() {
        return vectorFields;
    }

    @JsonAnySetter
    public void setVectorField(String key, List<Float> value) {
        this.vectorFields.put(key, value);
    }

    public void addVectorField(String fieldName, List<Float> vector) {
        vectorFields.put(fieldName, vector);
    }

    public List<Float> getVectorField(String fieldName) {
        return vectorFields.get(fieldName);
    }
}
