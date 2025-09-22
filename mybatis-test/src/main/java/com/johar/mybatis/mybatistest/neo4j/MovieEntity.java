package com.johar.mybatis.mybatistest.neo4j;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/9/14 17:48]
 * @updateUser : [johar]
 * @updateTime : [2025/9/14 17:48]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Getter
@Setter
@ToString
@Node("Movie")
public class MovieEntity implements Serializable {

    @Id
    private String title;

    @Property("tmdbID")
    private Long tmdbID;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<PersonEntity> actors = new ArrayList<>();
}