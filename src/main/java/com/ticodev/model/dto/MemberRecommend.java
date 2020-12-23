package com.ticodev.model.dto;

import java.util.Date;

public class MemberRecommend {

    private int memberNum;
    private int contentType;
    private int contentNum;
    private Date datetime;
    private boolean isCancel;

    @Override
    public String toString() {
        return "MemberRecommend{" +
                "memberNum=" + memberNum +
                ", contentType=" + contentType +
                ", contentNum=" + contentNum +
                ", datetime=" + datetime +
                ", isCancel=" + isCancel +
                '}';
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public void setCancel(boolean cancel) {
        isCancel = cancel;
    }
}
