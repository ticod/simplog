package com.ticodev.model.dto;

import java.util.Date;

public class BlogBoardComment {

    private int cmNum;
    private int bbNum;
    private int mbNum;
    private int bcParentNum;
    private String bcContent;
    private Date bcCreatedDatetime;
    private Date bcLastModifiedDatetime;
    private boolean bcIsDelete;
    private boolean bcIsSecret;

    @Override
    public String toString() {
        return "BlogBoardComment{" +
                "cmNum=" + cmNum +
                ", bbNum=" + bbNum +
                ", mbNum=" + mbNum +
                ", bcParentNum=" + bcParentNum +
                ", bcContent='" + bcContent + '\'' +
                ", bcCreatedDatetime=" + bcCreatedDatetime +
                ", bcLastModifiedDatetime=" + bcLastModifiedDatetime +
                ", bcIsDelete=" + bcIsDelete +
                ", bcIsSecret=" + bcIsSecret +
                '}';
    }

    public int getCmNum() {
        return cmNum;
    }

    public void setCmNum(int cmNum) {
        this.cmNum = cmNum;
    }

    public int getBbNum() {
        return bbNum;
    }

    public void setBbNum(int bbNum) {
        this.bbNum = bbNum;
    }

    public int getMbNum() {
        return mbNum;
    }

    public void setMbNum(int mbNum) {
        this.mbNum = mbNum;
    }

    public int getBcParentNum() {
        return bcParentNum;
    }

    public void setBcParentNum(int bcParentNum) {
        this.bcParentNum = bcParentNum;
    }

    public String getBcContent() {
        return bcContent;
    }

    public void setBcContent(String bcContent) {
        this.bcContent = bcContent;
    }

    public Date getBcCreatedDatetime() {
        return bcCreatedDatetime;
    }

    public void setBcCreatedDatetime(Date bcCreatedDatetime) {
        this.bcCreatedDatetime = bcCreatedDatetime;
    }

    public Date getBcLastModifiedDatetime() {
        return bcLastModifiedDatetime;
    }

    public void setBcLastModifiedDatetime(Date bcLastModifiedDatetime) {
        this.bcLastModifiedDatetime = bcLastModifiedDatetime;
    }

    public boolean isBcIsDelete() {
        return bcIsDelete;
    }

    public void setBcIsDelete(boolean bcIsDelete) {
        this.bcIsDelete = bcIsDelete;
    }

    public boolean isBcIsSecret() {
        return bcIsSecret;
    }

    public void setBcIsSecret(boolean bcIsSecret) {
        this.bcIsSecret = bcIsSecret;
    }
}
