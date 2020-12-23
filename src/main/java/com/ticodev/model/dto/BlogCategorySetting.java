package com.ticodev.model.dto;

public class BlogCategorySetting {

    private int num;
    private int blogNum;
    private int sequence;
    private int parent;
    private String name;

    @Override
    public String toString() {
        return "BlogCategorySetting{" +
                "num=" + num +
                ", blogNum=" + blogNum +
                ", sequence=" + sequence +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
