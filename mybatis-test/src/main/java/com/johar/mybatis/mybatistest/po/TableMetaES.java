package com.johar.mybatis.mybatistest.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
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

    @JSONField(unwrapped = true, serialize = true,deserialize = true)
    // 使用Map存储动态向量字段，键为"vector_128"、"vector_512"等
    private Map<String, List<Float>> vectorFields = new HashMap<>();

    // 添加向量字段的方法
    public void addVectorField(String fieldName, List<Float> vector) {
        vectorFields.put(fieldName, vector);
    }

    // 获取向量字段的方法
    public List<Float> getVectorField(String fieldName) {
        return vectorFields.get(fieldName);
    }
}
