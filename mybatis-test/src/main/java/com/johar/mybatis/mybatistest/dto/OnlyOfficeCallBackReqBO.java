package com.johar.mybatis.mybatistest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/6/22 21:01]
 * @updateUser : [johar]
 * @updateTime : [2025/6/22 21:01]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Getter
@Setter
@ToString
public class OnlyOfficeCallBackReqBO {
    /**
     * 定义编辑的文档标识符。
     */
    private String key;

    /**
     * 定义文档的状态。可以具有以下值：
     * 0 - 找不到带有密钥标识符的文档，
     * 1 - 正在编辑文档，
     * 2 - 文件已准备好保存，
     * 3 - 发生了文档保存错误，
     * 4 - 文件关闭，没有变化，
     * 6 - 正在编辑文档，但保存当前文档状态，
     * 7 - 强制保存文档时发生错误。
     */
    @NotNull(message = "文档状态 不能为空")
    private Integer status;

    /**
     * 定义要与文档存储服务一起保存的已编辑文档的链接。
     * 当状态值仅等于2或3时，链接存在。
     */
    private String url;

    /**
     * 定义打开文档进行编辑的用户的标识符列表;
     */
    private List<String> users;
}
