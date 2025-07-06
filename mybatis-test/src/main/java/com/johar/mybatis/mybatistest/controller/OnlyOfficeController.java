package com.johar.mybatis.mybatistest.controller;

import com.johar.mybatis.mybatistest.dto.OnlyOfficeCallBackReqBO;
import com.johar.mybatis.mybatistest.dto.OnlyOfficeCallBackRespBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/6/22 20:59]
 * @updateUser : [johar]
 * @updateTime : [2025/6/22 20:59]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Slf4j
@RestController
@RequestMapping("/expose/online/office")
public class OnlyOfficeController {

    @PostMapping(value = "/callback")
    public OnlyOfficeCallBackRespBO callback(@RequestBody @Valid OnlyOfficeCallBackReqBO reqBO) {
        try {
            return OnlyOfficeCallBackRespBO.buildSuccess();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            log.error("在线文档回调接口异常,信息：{}", errorMessage, e);
            return OnlyOfficeCallBackRespBO.buildFail();
        }
    }
}
