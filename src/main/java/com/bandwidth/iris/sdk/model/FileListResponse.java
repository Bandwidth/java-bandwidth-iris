package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;


@XmlRootElement(name="fileListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class FileListResponse extends BaseModel {

    @XmlElement(name = "fileCount")
    private int fileCount;

    @XmlElement(name = "fileNames")
    private String[] fileNames;

    @XmlElement(name = "resultCode")
    private int resultCode;

    @XmlElement(name = "resultMessage")
    private String resultMessage;

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public String[] getFileNames() {
        return fileNames;
    }

    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

}