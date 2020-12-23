package com.ticodev.model.dto;

import java.util.Date;

public class BlogBoard {

    private int num;
    private int blogNum;
    private int commentNum;
    private String subject;
    private String content;
    private String file;
    private Date created;
    private Date lastModified;
    private int hits;
    private int isDelete;

    @Override
    public String toString() {
        return "BlogBoard{" +
                "num=" + num +
                ", blogNum=" + blogNum +
                ", commentNum=" + commentNum +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", file='" + file + '\'' +
                ", created=" + created +
                ", lastModified=" + lastModified +
                ", hits=" + hits +
                ", isDelete=" + isDelete +
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

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
