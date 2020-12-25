package com.ticodev.model.dto;

import java.util.Date;

/*
블로그 플랫폼 일일 데이터
 */
public class PlatformData {

    private Date bfDate;
    private int bfHits;

    @Override
    public String toString() {
        return "PlatformData{" +
                "bfDate=" + bfDate +
                ", bfHits=" + bfHits +
                '}';
    }

    public Date getBfDate() {
        return bfDate;
    }

    public void setBfDate(Date bfDate) {
        this.bfDate = bfDate;
    }

    public int getBfHits() {
        return bfHits;
    }

    public void setBfHits(int bfHits) {
        this.bfHits = bfHits;
    }
}
