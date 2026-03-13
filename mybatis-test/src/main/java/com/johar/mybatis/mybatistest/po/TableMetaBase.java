package com.johar.mybatis.mybatistest.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/3/11 0:04]
 * @updateUser : [johar]
 * @updateTime : [2026/3/11 0:04]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Data
@ToString
public class TableMetaBase implements Serializable {
    @JSONField(name = "table_id")
    private String tableId;

    @JSONField(name = "db_table_name")
    private String dbTableName;

    @JSONField(name = "table_name")
    private String description;

    @JSONField(name = "create_time")
    private Date createTime;

    @JSONField(name = "update_time")
    private Date updateTime;

    @JSONField(name = "create_by")
    private String createBy;

    @JSONField(name = "update_by")
    private String updateBy;
}
