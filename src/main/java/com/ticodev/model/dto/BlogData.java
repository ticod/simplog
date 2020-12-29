package com.ticodev.model.dto;

import java.util.Date;

public class BlogData {

    private Date bdDate;
    private int bgNum;
    private int bdHits;

    @Override
    public String toString() {
        return "BlogData{" +
                "bdDate=" + bdDate +
                ", bgNum=" + bgNum +
                ", bdHits=" + bdHits +
                '}';
    }

    public Date getBdDate() {
        return bdDate;
    }

    public void setBdDate(Date bdDate) {
        this.bdDate = bdDate;
    }

    public int getBgNum() {
        return bgNum;
    }

    public void setBgNum(int bgNum) {
        this.bgNum = bgNum;
    }

    public int getBdHits() {
        return bdHits;
    }

    public void setBdHits(int bdHits) {
        this.bdHits = bdHits;
    }
}
