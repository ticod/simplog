package com.ticodev.model.dto;

/*
블로그 분야 테이블
 */
public class BlogType {

    private int type;
    private int name;

    @Override
    public String toString() {
        return "BlogType{" +
                "type=" + type +
                ", name=" + name +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

}
