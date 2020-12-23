package com.ticodev.model.dto;

import java.util.Date;

/*
블로그 플랫폼 일일 데이터
 */
public class PlatformData {

    private Date date;
    private int hits;

    @Override
    public String toString() {
        return "PlatformData{" +
                "date=" + date +
                ", hits=" + hits +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
