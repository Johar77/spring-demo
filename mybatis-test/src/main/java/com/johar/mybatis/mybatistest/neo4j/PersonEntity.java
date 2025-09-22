package com.johar.mybatis.mybatistest.neo4j;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.io.Serializable;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/9/14 17:29]
 * @updateUser : [johar]
 * @updateTime : [2025/9/14 17:29]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Getter
@ToString
@Setter
@Node("Person")
public class PersonEntity implements Serializable {

    @Id
    private String name;
    @Property("born")
    private String born;
    @Property("tmdbID")
    private Long tmdbID;
}