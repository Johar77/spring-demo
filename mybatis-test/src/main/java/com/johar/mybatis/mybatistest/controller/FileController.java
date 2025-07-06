package com.johar.mybatis.mybatistest.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/6/22 20:59]
 * @updateUser : [johar]
 * @updateTime : [2025/6/22 20:59]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@RequestMapping("/expose/uploadFile")
@RestController
public class FileController {

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() throws MalformedURLException, FileNotFoundException {
        // 定义要下载的本地文件路径
        Path filePath = Paths.get("C:\\Users\\johar\\Desktop\\上线版本\\ICRM-上线方案模板.doc"); // 替换为实际的文件路径

        Resource resource = new UrlResource(filePath.toUri());
        String filename = resource.getFilename();
        if (filename == null) {
            throw new FileNotFoundException("文件名无法解析: " + filePath);
        }
        String encodedFilename = UriUtils.encode(filename, StandardCharsets.UTF_8);

        if (resource.exists() || resource.isReadable()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFilename + "\"; filename*=UTF-8''" + encodedFilename)
                    .body(resource);
        } else {
            throw new RuntimeException("文件无法读取: " + filePath);
        }
    }

}
