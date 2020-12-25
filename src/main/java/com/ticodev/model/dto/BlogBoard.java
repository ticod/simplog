package com.ticodev.model.dto;

import java.util.Date;

public class BlogBoard {

    private int bbNum;
    private int bgNum;
    private int ctNum;
    private String bbSubject;
    private String bbContent;
    private String bbFile;
    private Date bbCreatedDatetime;
    private Date bbLastModifiedDatetime;
    private int bbHits;
    private int bbIsDelete;

    @Override
    public String toString() {
        return "BlogBoard{" +
                "bbNum=" + bbNum +
                ", bgNum=" + bgNum +
                ", ctNum=" + ctNum +
                ", bbSubject='" + bbSubject + '\'' +
                ", bbContent='" + bbContent + '\'' +
                ", bbFile='" + bbFile + '\'' +
                ", bbCreatedDatetime=" + bbCreatedDatetime +
                ", bbLastModifiedDatetime=" + bbLastModifiedDatetime +
                ", bbHits=" + bbHits +
                ", bbIsDelete=" + bbIsDelete +
                '}';
    }

    public int getBbNum() {
        return bbNum;
    }

    public void setBbNum(int bbNum) {
        this.bbNum = bbNum;
    }

    public int getBgNum() {
        return bgNum;
    }

    public void setBgNum(int bgNum) {
        this.bgNum = bgNum;
    }

    public int getCtNum() {
        return ctNum;
    }

    public void setCtNum(int ctNum) {
        this.ctNum = ctNum;
    }

    public String getBbSubject() {
        return bbSubject;
    }

    public void setBbSubject(String bbSubject) {
        this.bbSubject = bbSubject;
    }

    public String getBbContent() {
        return bbContent;
    }

    public void setBbContent(String bbContent) {
        this.bbContent = bbContent;
    }

    public String getBbFile() {
        return bbFile;
    }

    public void setBbFile(String bbFile) {
        this.bbFile = bbFile;
    }

    public Date getBbCreatedDatetime() {
        return bbCreatedDatetime;
    }

    public void setBbCreatedDatetime(Date bbCreatedDatetime) {
        this.bbCreatedDatetime = bbCreatedDatetime;
    }

    public Date getBbLastModifiedDatetime() {
        return bbLastModifiedDatetime;
    }

    public void setBbLastModifiedDatetime(Date bbLastModifiedDatetime) {
        this.bbLastModifiedDatetime = bbLastModifiedDatetime;
    }

    public int getBbHits() {
        return bbHits;
    }

    public void setBbHits(int bbHits) {
        this.bbHits = bbHits;
    }

    public int getBbIsDelete() {
        return bbIsDelete;
    }

    public void setBbIsDelete(int bbIsDelete) {
        this.bbIsDelete = bbIsDelete;
    }
}
