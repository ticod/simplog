package com.ticodev.model.dto;

/*
블로그 분야 테이블
 */
public class BlogType {

    private int btType;
    private int btName;

    @Override
    public String toString() {
        return "BlogType{" +
                "btType=" + btType +
                ", btName=" + btName +
                '}';
    }

    public int getBtType() {
        return btType;
    }

    public void setBtType(int btType) {
        this.btType = btType;
    }

    public int getBtName() {
        return btName;
    }

    public void setBtName(int btName) {
        this.btName = btName;
    }
}
