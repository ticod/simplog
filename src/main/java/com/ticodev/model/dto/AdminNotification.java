package com.ticodev.model.dto;

import java.util.Date;

public class AdminNotification {

    private int anNum;
    private int mbNum;
    private int anType;
    private int anSubject;
    private int anContent;
    private Date anDatetime;
    private int contentType;
    private int contentNum;
    private boolean anIsProcessed;

    @Override
    public String toString() {
        return "AdminNotification{" +
                "anNum=" + anNum +
                ", mbNum=" + mbNum +
                ", anType=" + anType +
                ", anSubject=" + anSubject +
                ", anContent=" + anContent +
                ", anDatetime=" + anDatetime +
                ", contentType=" + contentType +
                ", contentNum=" + contentNum +
                ", anIsProcessed=" + anIsProcessed +
                '}';
    }

    public int getAnNum() {
        return anNum;
    }

    public void setAnNum(int anNum) {
        this.anNum = anNum;
    }

    public int getMbNum() {
        return mbNum;
    }

    public void setMbNum(int mbNum) {
        this.mbNum = mbNum;
    }

    public int getAnType() {
        return anType;
    }

    public void setAnType(int anType) {
        this.anType = anType;
    }

    public int getAnSubject() {
        return anSubject;
    }

    public void setAnSubject(int anSubject) {
        this.anSubject = anSubject;
    }

    public int getAnContent() {
        return anContent;
    }

    public void setAnContent(int anContent) {
        this.anContent = anContent;
    }

    public Date getAnDatetime() {
        return anDatetime;
    }

    public void setAnDatetime(Date anDatetime) {
        this.anDatetime = anDatetime;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public int getContentNum() {
        return contentNum;
    }

    public void setContentNum(int contentNum) {
        this.contentNum = contentNum;
    }

    public boolean isAnIsProcessed() {
        return anIsProcessed;
    }

    public void setAnIsProcessed(boolean anIsProcessed) {
        this.anIsProcessed = anIsProcessed;
    }
}
