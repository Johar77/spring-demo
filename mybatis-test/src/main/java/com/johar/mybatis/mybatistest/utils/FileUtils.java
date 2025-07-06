package com.johar.mybatis.mybatistest.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/6/22 20:51]
 * @updateUser : [johar]
 * @updateTime : [2025/6/22 20:51]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class FileUtils {
    /**
     * 获取文件扩展名
     * @param fileName 文件名
     * @return 扩展名
     */
    public static String getFileExtension(String fileName) {
        if (StringUtils.isBlank(fileName)){
            return "";
        }
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex == -1 || lastDotIndex == fileName.length() - 1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1);
    }
}