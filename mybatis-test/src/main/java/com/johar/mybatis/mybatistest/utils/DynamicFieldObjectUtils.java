package com.johar.mybatis.mybatistest.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static List<Float> generateRandomVectors(int dimension, float min, float max) {
        Random random = new Random();
        List<Float> result = new ArrayList<>(dimension);
        for (int j = 0; j < dimension; j++) {
            float randomValue = random.nextFloat() * (max - min) + min;
            result.add(randomValue);
        }
        return result;
    }

    public static Map<String, Object> toMap(TableMetaBase tableMetaBase, List<Float> vector) throws JsonProcessingException {
        String json = OBJECT_MAPPER.writeValueAsString(tableMetaBase);
        Map<String, Object> map = OBJECT_MAPPER.readValue(json, Map.class);
        if (!CollectionUtils.isEmpty(vector)) {
            String key = "vector_" + vector.size();
            map.put(key, vector);
        }
        return map;
    }

    public static String toJsonJackson(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    public static String toJsonFastjson(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T fromJsonJackson(String json, Class<T> clazz) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    public static <T> T fromJsonFastjson(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static void main(String[] args) throws JsonProcessingException {
        TableMetaES tableMeta = new TableMetaES();
        tableMeta.setTableId("table_001");
        tableMeta.setDbTableName("user_table");
        tableMeta.setDescription("用户表");

        List<Float> vector128 = generateRandomVectors(4, 0.0f, 1.0f);
        List<Float> vector512 = generateRandomVectors(4, 0.0f, 1.0f);

        tableMeta.addVectorField("vector_128", vector128);
        tableMeta.addVectorField("vector_512", vector512);

        System.out.println("=== Jackson Serialization ===");
        String jsonJackson = toJsonJackson(tableMeta);
        System.out.println("Jackson: " + jsonJackson);
        TableMetaES deserializedJackson = fromJsonJackson(jsonJackson, TableMetaES.class);
        System.out.println("Jackson deserialized vector_128: " + deserializedJackson.getVectorField("vector_128"));

        System.out.println("\n=== FastJSON Serialization ===");
        String jsonFastjson = toJsonFastjson(tableMeta);
        System.out.println("FastJSON: " + jsonFastjson);
        TableMetaES deserializedFastjson = fromJsonFastjson(jsonFastjson, TableMetaES.class);
        System.out.println("FastJSON deserialized vector_128: " + deserializedFastjson.getVectorField("vector_128"));
    }
}
