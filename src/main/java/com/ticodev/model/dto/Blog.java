package com.ticodev.model.dto;

import java.util.Date;

public class Blog {

    private int bgNum;
    private int mbNum;
    private int bgType;
    private String bgName;
    private String bgUrl;
    private String bgProfileImage;
    private String bgLogo;
    private String bgIntro;
    private int bgLayout;
    private int bgMainLayout;
    private Date bgCreatedDatetime;
    private String bgMainImage;
    private String bgMainIntro;

    @Override
    public String toString() {
        return "Blog{" +
                "bgNum=" + bgNum +
                ", mbNum=" + mbNum +
                ", bgType=" + bgType +
                ", bgName='" + bgName + '\'' +
                ", bgUrl='" + bgUrl + '\'' +
                ", bgProfileImage='" + bgProfileImage + '\'' +
                ", bgLogo='" + bgLogo + '\'' +
                ", bgIntro='" + bgIntro + '\'' +
                ", bgLayout=" + bgLayout +
                ", bgMainLayout=" + bgMainLayout +
                ", bgCreatedDatetime=" + bgCreatedDatetime +
                ", bgMainImage='" + bgMainImage + '\'' +
                ", bgMainIntro='" + bgMainIntro + '\'' +
                '}';
    }

    public int getBgNum() {
        return bgNum;
    }

    public void setBgNum(int bgNum) {
        this.bgNum = bgNum;
    }

    public int getMbNum() {
        return mbNum;
    }

    public void setMbNum(int mbNum) {
        this.mbNum = mbNum;
    }

    public int getBgType() {
        return bgType;
    }

    public void setBgType(int bgType) {
        this.bgType = bgType;
    }

    public String getBgName() {
        return bgName;
    }

    public void setBgName(String bgName) {
        this.bgName = bgName;
    }

    public String getBgUrl() {
        return bgUrl;
    }

    public void setBgUrl(String bgUrl) {
        this.bgUrl = bgUrl;
    }

    public String getBgProfileImage() {
        return bgProfileImage;
    }

    public void setBgProfileImage(String bgProfileImage) {
        this.bgProfileImage = bgProfileImage;
    }

    public String getBgLogo() {
        return bgLogo;
    }

    public void setBgLogo(String bgLogo) {
        this.bgLogo = bgLogo;
    }

    public String getBgIntro() {
        return bgIntro;
    }

    public void setBgIntro(String bgIntro) {
        this.bgIntro = bgIntro;
    }

    public int getBgLayout() {
        return bgLayout;
    }

    public void setBgLayout(int bgLayout) {
        this.bgLayout = bgLayout;
    }

    public int getBgMainLayout() {
        return bgMainLayout;
    }

    public void setBgMainLayout(int bgMainLayout) {
        this.bgMainLayout = bgMainLayout;
    }

    public Date getBgCreatedDatetime() {
        return bgCreatedDatetime;
    }

    public void setBgCreatedDatetime(Date bgCreatedDatetime) {
        this.bgCreatedDatetime = bgCreatedDatetime;
    }

    public String getBgMainImage() {
        return bgMainImage;
    }

    public void setBgMainImage(String bgMainImage) {
        this.bgMainImage = bgMainImage;
    }

    public String getBgMainIntro() {
        return bgMainIntro;
    }

    public void setBgMainIntro(String bgMainIntro) {
        this.bgMainIntro = bgMainIntro;
    }
}
