package com.ticodev.model.dto;

import java.util.Date;

public class Member {

    private int mbNum;
    private String mbId;
    private String mbPassword;
    private String mbSalt;
    private String mbName;
    private String mbEmail;
    private String mbTel;
    private String mbBirthday;
    private String mbProfileImage;
    private String mbProfileIntro;
    private Date mbSignup;
    private Date mbLastLogin;
    private boolean mbIsAdmin;

    @Override
    public String toString() {
        return "Member{" +
                "mbNum=" + mbNum +
                ", mbId='" + mbId + '\'' +
                ", mbPassword='" + mbPassword + '\'' +
                ", mbSalt='" + mbSalt + '\'' +
                ", mbName='" + mbName + '\'' +
                ", mbEmail='" + mbEmail + '\'' +
                ", mbTel='" + mbTel + '\'' +
                ", mbBirthday='" + mbBirthday + '\'' +
                ", mbProfileImage='" + mbProfileImage + '\'' +
                ", mbProfileIntro='" + mbProfileIntro + '\'' +
                ", mbSignup=" + mbSignup +
                ", mbLastLogin=" + mbLastLogin +
                ", mbIsAdmin=" + mbIsAdmin +
                '}';
    }

    public int getMbNum() {
        return mbNum;
    }

    public void setMbNum(int mbNum) {
        this.mbNum = mbNum;
    }

    public String getMbId() {
        return mbId;
    }

    public void setMbId(String mbId) {
        this.mbId = mbId;
    }

    public String getMbPassword() {
        return mbPassword;
    }

    public void setMbPassword(String mbPassword) {
        this.mbPassword = mbPassword;
    }

    public String getMbSalt() {
        return mbSalt;
    }

    public void setMbSalt(String mbSalt) {
        this.mbSalt = mbSalt;
    }

    public String getMbName() {
        return mbName;
    }

    public void setMbName(String mbName) {
        this.mbName = mbName;
    }

    public String getMbEmail() {
        return mbEmail;
    }

    public void setMbEmail(String mbEmail) {
        this.mbEmail = mbEmail;
    }

    public String getMbTel() {
        return mbTel;
    }

    public void setMbTel(String mbTel) {
        this.mbTel = mbTel;
    }

    public String getMbBirthday() {
        return mbBirthday;
    }

    public void setMbBirthday(String mbBirthday) {
        this.mbBirthday = mbBirthday;
    }

    public String getMbProfileImage() {
        return mbProfileImage;
    }

    public void setMbProfileImage(String mbProfileImage) {
        this.mbProfileImage = mbProfileImage;
    }

    public String getMbProfileIntro() {
        return mbProfileIntro;
    }

    public void setMbProfileIntro(String mbProfileIntro) {
        this.mbProfileIntro = mbProfileIntro;
    }

    public Date getMbSignup() {
        return mbSignup;
    }

    public void setMbSignup(Date mbSignup) {
        this.mbSignup = mbSignup;
    }

    public Date getMbLastLogin() {
        return mbLastLogin;
    }

    public void setMbLastLogin(Date mbLastLogin) {
        this.mbLastLogin = mbLastLogin;
    }

    public boolean isMbIsAdmin() {
        return mbIsAdmin;
    }

    public void setMbIsAdmin(boolean mbIsAdmin) {
        this.mbIsAdmin = mbIsAdmin;
    }
}
