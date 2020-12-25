package com.ticodev.model.dto;

import java.util.Date;

public class MemberRecommend {

    private int mbNum;
    private int contentType;
    private int contentNum;
    private Date mrDatetime;
    private boolean mrIsCancel;

    @Override
    public String toString() {
        return "MemberRecommend{" +
                "mbNum=" + mbNum +
                ", contentType=" + contentType +
                ", contentNum=" + contentNum +
                ", mrDatetime=" + mrDatetime +
                ", mrIsCancel=" + mrIsCancel +
                '}';
    }

    public int getMbNum() {
        return mbNum;
    }

    public void setMbNum(int mbNum) {
        this.mbNum = mbNum;
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

    public Date getMrDatetime() {
        return mrDatetime;
    }

    public void setMrDatetime(Date mrDatetime) {
        this.mrDatetime = mrDatetime;
    }

    public boolean isMrIsCancel() {
        return mrIsCancel;
    }

    public void setMrIsCancel(boolean mrIsCancel) {
        this.mrIsCancel = mrIsCancel;
    }
}
