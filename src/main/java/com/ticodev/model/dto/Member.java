package com.ticodev.model.dto;

import java.util.Date;

public class Member {

    private int num;
    private String id;
    private String password;
    private String name;
    private String email;
    private String tel;
    private String birthday;
    private String profileImage;
    private String profileIntro;
    private Date signup;
    private Date lastLogin;
    private boolean isAdmin;

    @Override
    public String toString() {
        return "Member{" +
                "num=" + num +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", birthday='" + birthday + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", profileIntro='" + profileIntro + '\'' +
                ", signup=" + signup +
                ", lastLogin=" + lastLogin +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileIntro() {
        return profileIntro;
    }

    public void setProfileIntro(String profileIntro) {
        this.profileIntro = profileIntro;
    }

    public Date getSignup() {
        return signup;
    }

    public void setSignup(Date signup) {
        this.signup = signup;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
