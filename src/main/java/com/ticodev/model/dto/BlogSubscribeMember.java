package com.ticodev.model.dto;

public class BlogSubscribeMember {

    private int memberNum;
    private int blogNum;

    @Override
    public String toString() {
        return "BlogSubscribeMember{" +
                "memberNum=" + memberNum +
                ", blogNum=" + blogNum +
                '}';
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }
}
