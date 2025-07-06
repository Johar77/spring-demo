package com.johar.mybatis.mybatistest.dto;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/6/22 20:49]
 * @updateUser : [johar]
 * @updateTime : [2025/6/22 20:49]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class OnlineOfficeDTO {
    private String fileName;
    private String documentType;
    private String fileType;
    private String userName;
    private String userEmail;
    private String key;
    private String docServiceApiUrl;
    private String downloadUrl;
    private String saveUrl;
    private boolean isEdit;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDocServiceApiUrl() {
        return docServiceApiUrl;
    }

    public void setDocServiceApiUrl(String docServiceApiUrl) {
        this.docServiceApiUrl = docServiceApiUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getSaveUrl() {
        return saveUrl;
    }

    public void setSaveUrl(String saveUrl) {
        this.saveUrl = saveUrl;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
}