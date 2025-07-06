package com.johar.mybatis.mybatistest.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.johar.mybatis.mybatistest.dto.OnlineOfficeDTO;
import com.johar.mybatis.mybatistest.utils.FileUtils; // 添加FileUtils的import
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/6/22 20:47]
 * @updateUser : [johar]
 * @updateTime : [2025/6/22 20:47]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Slf4j
@RequestMapping("/editor")
@Controller
public class EditorController {

    @GetMapping("/index")
    public ModelAndView index () {
        OnlineOfficeDTO fileModel = new OnlineOfficeDTO();
        String fileName = "ICRM-上线方案模板.doc";
        String docType = "word";
        //String onlyOfficeUrl = "http://localhost:8081";
        String onlyOfficeUrl = "https://127.0.0.1:8443";

















































































































































        
        String crmworkbenchUrl = "http://host.docker.internal:9994";

        fileModel.setFileName(fileName);
        String suffix = FileUtils.getFileExtension(fileName);
        if (StringUtils.isNotBlank(suffix)) {
            suffix = suffix.toLowerCase();
        }
        fileModel.setDocumentType(docType);
        fileModel.setFileType(suffix);
        fileModel.setUserName("张三");
        fileModel.setUserEmail("san.zhang@qq.com");
        fileModel.setKey(UUID.randomUUID().toString().replace("-", ""));
        fileModel.setDocServiceApiUrl(onlyOfficeUrl + "/web-apps/apps/api/documents/api.js");
        fileModel.setDownloadUrl(crmworkbenchUrl + "/expose/uploadFile/download");
        fileModel.setSaveUrl(crmworkbenchUrl + "/expose/online/office/callback");
        fileModel.setIsEdit(false);
        ModelAndView result = new ModelAndView("edit/office");
        log.info("返回viewmodel:{}", JSON.toJSONString(fileModel));
        result.addObject("model", fileModel);
        return result;
    }
}