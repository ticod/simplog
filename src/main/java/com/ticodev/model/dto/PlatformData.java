package com.ticodev.model.dto;

import java.util.Date;

/*
블로그 플랫폼 일일 데이터
 */
public class PlatformData {

    private Date bpData;
    private int bpHits;

    @Override
    public String toString() {
        return "PlatformData{" +
                "bpDate=" + bpData +
                ", bpHits=" + bpHits +
                '}';
    }

    public Date getBpData() {
        return bpData;
    }

    public void setBpData(Date bpData) {
        this.bpData = bpData;
    }

    public int getBpHits() {
        return bpHits;
    }

    public void setBpHits(int bpHits) {
        this.bpHits = bpHits;
    }
}
