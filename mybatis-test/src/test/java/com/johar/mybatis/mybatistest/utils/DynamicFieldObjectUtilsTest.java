package com.johar.mybatis.mybatistest.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johar.mybatis.mybatistest.po.TableMetaES;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DynamicFieldObjectUtilsTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGenerateRandomVectors() {
        List<Float> vectors = DynamicFieldObjectUtils.generateRandomVectors(128, 0.0f, 1.0f);
        assertNotNull(vectors);
        assertEquals(128, vectors.size());
        for (Float f : vectors) {
            assertTrue(f >= 0.0f && f < 1.0f);
        }
    }

    @Test
    void testJacksonSerialize() throws JsonProcessingException {
        TableMetaES tableMeta = createTableMetaES();
        String json = objectMapper.writeValueAsString(tableMeta);
        System.out.println("Jackson JSON: " + json);

        assertNotNull(json);
        assertTrue(json.contains("\"table_id\":\"table_001\""));
        assertTrue(json.contains("\"vector_128\""));
        assertTrue(json.contains("\"vector_512\""));
    }

    @Test
    void testJacksonDeserialize() throws JsonProcessingException {
        String json = "{\"table_id\":\"table_001\",\"db_table_name\":\"user_table\",\"table_name\":\"用户表\"," +
                "\"vector_128\":[0.1,0.2,0.3,0.4],\"vector_512\":[0.5,0.6,0.7,0.8]}";

        TableMetaES tableMeta = objectMapper.readValue(json, TableMetaES.class);

        assertNotNull(tableMeta);
        assertEquals("table_001", tableMeta.getTableId());
        assertEquals("user_table", tableMeta.getDbTableName());
        assertEquals("用户表", tableMeta.getDescription());
        assertNotNull(tableMeta.getVectorField("vector_128"));
        assertEquals(4, tableMeta.getVectorField("vector_128").size());
        assertNotNull(tableMeta.getVectorField("vector_512"));
        assertEquals(4, tableMeta.getVectorField("vector_512").size());
    }

    @Test
    void testFastjsonSerialize() {
        TableMetaES tableMeta = createTableMetaES();
        String json = JSON.toJSONString(tableMeta);
        System.out.println("FastJSON JSON: " + json);

        assertNotNull(json);
        assertTrue(json.contains("\"table_id\":\"table_001\""));
        assertTrue(json.contains("\"vector_128\""));
        assertTrue(json.contains("\"vector_512\""));
    }

    @Test
    void testFastjsonDeserialize() {
        String json = "{\"table_id\":\"table_001\",\"db_table_name\":\"user_table\",\"table_name\":\"用户表\"," +
                "\"vector_128\":[0.1,0.2,0.3,0.4],\"vector_512\":[0.5,0.6,0.7,0.8]}";

        TableMetaES tableMeta = JSON.parseObject(json, TableMetaES.class);

        assertNotNull(tableMeta);
        assertEquals("table_001", tableMeta.getTableId());
        assertEquals("user_table", tableMeta.getDbTableName());
        assertEquals("用户表", tableMeta.getDescription());
        assertNotNull(tableMeta.getVectorField("vector_128"));
        assertEquals(4, tableMeta.getVectorField("vector_128").size());
        assertNotNull(tableMeta.getVectorField("vector_512"));
        assertEquals(4, tableMeta.getVectorField("vector_512").size());
    }

    @Test
    void testJacksonSerializeDeserializeRoundTrip() throws JsonProcessingException {
        TableMetaES original = createTableMetaES();
        String json = objectMapper.writeValueAsString(original);
        TableMetaES deserialized = objectMapper.readValue(json, TableMetaES.class);

        assertEquals(original.getTableId(), deserialized.getTableId());
        assertEquals(original.getDbTableName(), deserialized.getDbTableName());
        assertEquals(original.getDescription(), deserialized.getDescription());
        assertNotNull(deserialized.getVectorField("vector_128"));
        assertNotNull(deserialized.getVectorField("vector_512"));
    }

    @Test
    void testFastjsonSerializeDeserializeRoundTrip() {
        TableMetaES original = createTableMetaES();
        String json = JSON.toJSONString(original);
        TableMetaES deserialized = JSON.parseObject(json, TableMetaES.class);

        assertEquals(original.getTableId(), deserialized.getTableId());
        assertEquals(original.getDbTableName(), deserialized.getDbTableName());
        assertEquals(original.getDescription(), deserialized.getDescription());
        assertNotNull(deserialized.getVectorField("vector_128"));
        assertNotNull(deserialized.getVectorField("vector_512"));
    }

    @Test
    void testJacksonAndFastjsonCompatibility() throws JsonProcessingException {
        TableMetaES original = createTableMetaES();

        String jacksonJson = objectMapper.writeValueAsString(original);
        String fastjsonJson = JSON.toJSONString(original);

        System.out.println("Jackson: " + jacksonJson);
        System.out.println("FastJSON: " + fastjsonJson);

        assertNotNull(jacksonJson);
        assertNotNull(fastjsonJson);
        assertTrue(jacksonJson.contains("vector_128"));
        assertTrue(fastjsonJson.contains("vector_128"));

        TableMetaES fromJackson = objectMapper.readValue(jacksonJson, TableMetaES.class);
        TableMetaES fromFastjson = JSON.parseObject(fastjsonJson, TableMetaES.class);

        assertNotNull(fromJackson.getVectorField("vector_128"));
        assertNotNull(fromFastjson.getVectorField("vector_128"));
    }

    private TableMetaES createTableMetaES() {
        TableMetaES tableMeta = new TableMetaES();
        tableMeta.setTableId("table_001");
        tableMeta.setDbTableName("user_table");
        tableMeta.setDescription("用户表");

        List<Float> vector128 = DynamicFieldObjectUtils.generateRandomVectors(4, 0.0f, 1.0f);
        List<Float> vector512 = DynamicFieldObjectUtils.generateRandomVectors(4, 0.0f, 1.0f);

        tableMeta.addVectorField("vector_128", vector128);
        tableMeta.addVectorField("vector_512", vector512);

        return tableMeta;
    }
}