package com.ticodev.model.dto;

import java.util.Date;

public class AdminNotification {

    private int num;
    private int memberNum;
    private int type;
    private int subject;
    private int content;
    private Date datetime;
    private int contentType;
    private int contentNum;
    private boolean isProcessed;

    @Override
    public String toString() {
        return "AdminNotification{" +
                "num=" + num +
                ", memberNum=" + memberNum +
                ", type=" + type +
                ", subject=" + subject +
                ", content=" + content +
                ", datetime=" + datetime +
                ", contentType=" + contentType +
                ", contentNum=" + contentNum +
                ", isProcessed=" + isProcessed +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }
}
