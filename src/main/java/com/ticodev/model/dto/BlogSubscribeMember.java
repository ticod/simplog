package com.ticodev.model.dto;

public class BlogSubscribeMember {

    private int mbNum;
    private int bgNum;

    @Override
    public String toString() {
        return "BlogSubscribeMember{" +
                "mbNum=" + mbNum +
                ", bgNum=" + bgNum +
                '}';
    }

    public int getMbNum() {
        return mbNum;
    }

    public void setMbNum(int mbNum) {
        this.mbNum = mbNum;
    }

    public int getBgNum() {
        return bgNum;
    }

    public void setBgNum(int bgNum) {
        this.bgNum = bgNum;
    }
}
