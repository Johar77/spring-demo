package com.johar.mybatis.mybatistest.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.johar.mybatis.mybatistest.po.TableMetaBase;
import com.johar.mybatis.mybatistest.po.TableMetaES;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/3/10 23:37]
 * @updateUser : [johar]
 * @updateTime : [2026/3/10 23:37]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class DynamicFieldObjectUtils {

    /**
     * 生成指定维度的随机向量列表
     *
     * @param dimension 每个向量的维度
     * @param min       向量值的最小值（默认0.0f）
     * @param max       向量值的最大值（默认1.0f）
     * @return 包含count个向量的列表，每个向量有dimension个浮点数
     */
    public static List<Float> generateRandomVectors(int dimension, float min, float max) {
        Random random = new Random();
        List<Float> result = new ArrayList<>(dimension);
        for (int j = 0; j < dimension; j++) {
            // 生成[min, max)范围内的随机浮点数
            float randomValue = random.nextFloat() * (max - min) + min;
            result.add(randomValue);
        }

        return result;
    }

    public static JSONObject toMap(TableMetaBase tableMetaBase, List<Float> vector) {
        String json = JSON.toJSONString(tableMetaBase);
        JSONObject jsonObject = JSON.parseObject(json);
        if (!CollectionUtils.isEmpty(vector)) {
            String key = "vector_" + vector.size();
            jsonObject.put(key, vector);
        }

        return jsonObject;
    }

    public static void main(String[] args) {
        // 创建TableMetaES对象
        TableMetaES tableMeta = new TableMetaES();
        tableMeta.setTableId("table_001");
        tableMeta.setDbTableName("user_table");
        tableMeta.setDescription("用户表");

        // 添加动态向量字段
        List<Float> vector128 = generateRandomVectors(128, 0.0f, 1.0f); // 128维向量
        List<Float> vector512 = generateRandomVectors(512, 0.0f, 1.0f); // 512维向量

        tableMeta.addVectorField("vector_128", vector128);
        tableMeta.addVectorField("vector_512", vector512);

        // 序列化为JSON
        String json = JSON.toJSONString(tableMeta);
        System.out.println(json);
        TableMetaES tableMeta2 = JSON.parseObject(json, TableMetaES.class);
        System.out.println(tableMeta2);


        TableMetaBase metaBase = new TableMetaBase();
        metaBase.setTableId("table_001");
        metaBase.setDbTableName("user_table");
        metaBase.setDescription("用户表");
        JSONObject jsonObject = toMap(metaBase, vector128);
        String json2 = jsonObject.toJSONString();
        System.out.println(json2);

        TableMetaBase metaBase2 = JSON.parseObject(json2, TableMetaBase.class);
        System.out.println(metaBase2);
    }
}
