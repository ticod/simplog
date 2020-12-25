package com.ticodev.model.dto;

import java.util.Date;

public class MemberNotification {

    private int mbNum;
    private int notificationType;
    private int notificationNum;
    private Date mnDatetime;
    private boolean mnIsProcess;

    @Override
    public String toString() {
        return "MemberNotification{" +
                "mbNum=" + mbNum +
                ", notificationType=" + notificationType +
                ", notificationNum=" + notificationNum +
                ", mnDatetime=" + mnDatetime +
                ", mnIsProcess=" + mnIsProcess +
                '}';
    }

    public int getMbNum() {
        return mbNum;
    }

    public void setMbNum(int mbNum) {
        this.mbNum = mbNum;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public int getNotificationNum() {
        return notificationNum;
    }

    public void setNotificationNum(int notificationNum) {
        this.notificationNum = notificationNum;
    }

    public Date getMnDatetime() {
        return mnDatetime;
    }

    public void setMnDatetime(Date mnDatetime) {
        this.mnDatetime = mnDatetime;
    }

    public boolean isMnIsProcess() {
        return mnIsProcess;
    }

    public void setMnIsProcess(boolean mnIsProcess) {
        this.mnIsProcess = mnIsProcess;
    }
}
