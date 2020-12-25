package com.ticodev.model.dto;

public class BlogCategorySetting {

    private int ctNum;
    private int bgNum;
    private int ctSequence;
    private int ctParent;
    private String ctName;

    @Override
    public String toString() {
        return "BlogCategorySetting{" +
                "ctNum=" + ctNum +
                ", bgNum=" + bgNum +
                ", ctSequence=" + ctSequence +
                ", ctParent=" + ctParent +
                ", ctName='" + ctName + '\'' +
                '}';
    }

    public int getCtNum() {
        return ctNum;
    }

    public void setCtNum(int ctNum) {
        this.ctNum = ctNum;
    }

    public int getBgNum() {
        return bgNum;
    }

    public void setBgNum(int bgNum) {
        this.bgNum = bgNum;
    }

    public int getCtSequence() {
        return ctSequence;
    }

    public void setCtSequence(int ctSequence) {
        this.ctSequence = ctSequence;
    }

    public int getCtParent() {
        return ctParent;
    }

    public void setCtParent(int ctParent) {
        this.ctParent = ctParent;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }
}
