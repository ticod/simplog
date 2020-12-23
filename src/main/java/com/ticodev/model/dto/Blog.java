package com.ticodev.model.dto;

import java.util.Date;

public class Blog {

    private int num;
    private int memberNum;
    private int type;
    private String name;
    private String url;
    private String profileImage;
    private String logo;
    private String intro;
    private Date created;
    private int layout;
    private int mainLayout;
    private String mainImage;
    private String mainIntro;

    @Override
    public String toString() {
        return "Blog{" +
                "num=" + num +
                ", memberNum=" + memberNum +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", logo='" + logo + '\'' +
                ", intro='" + intro + '\'' +
                ", layout=" + layout +
                ", mainLayout=" + mainLayout +
                ", created=" + created +
                ", mainImage='" + mainImage + '\'' +
                ", mainIntro='" + mainIntro + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getMainLayout() {
        return mainLayout;
    }

    public void setMainLayout(int mainLayout) {
        this.mainLayout = mainLayout;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getMainIntro() {
        return mainIntro;
    }

    public void setMainIntro(String mainIntro) {
        this.mainIntro = mainIntro;
    }
}
