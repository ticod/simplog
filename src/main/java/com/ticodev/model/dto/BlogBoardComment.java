package com.ticodev.model.dto;

import java.util.Date;

public class BlogBoardComment {

    private int num;
    private int boardNum;
    private int memberNum;
    private int parentNum;
    private String content;
    private Date created;
    private Date lastModified;
    private boolean isDelete;
    private boolean isSecret;

    @Override
    public String toString() {
        return "BlogBoardComment{" +
                "num=" + num +
                ", boardNum=" + boardNum +
                ", memberNum=" + memberNum +
                ", parentNum=" + parentNum +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", lastModified=" + lastModified +
                ", isDelete=" + isDelete +
                ", isSecret=" + isSecret +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public int getParentNum() {
        return parentNum;
    }

    public void setParentNum(int parentNum) {
        this.parentNum = parentNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean secret) {
        isSecret = secret;
    }
}
