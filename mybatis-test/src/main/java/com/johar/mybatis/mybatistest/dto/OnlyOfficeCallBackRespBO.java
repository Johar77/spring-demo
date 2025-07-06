package com.johar.mybatis.mybatistest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/6/22 21:02]
 * @updateUser : [johar]
 * @updateTime : [2025/6/22 21:02]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Getter
@Setter
@ToString
public class OnlyOfficeCallBackRespBO {

    private Integer error;

    private String message;

    public OnlyOfficeCallBackRespBO() {
    }

    public OnlyOfficeCallBackRespBO(Integer error, String message) {
        this.error = error;
        this.message = message;
    }

    public static OnlyOfficeCallBackRespBO buildSuccess() {
        return new OnlyOfficeCallBackRespBO(0, "成功");
    }

    public static OnlyOfficeCallBackRespBO buildFail() {
        return new OnlyOfficeCallBackRespBO(-1, "失败");
    }
}
