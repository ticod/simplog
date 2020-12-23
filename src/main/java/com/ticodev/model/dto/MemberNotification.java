package com.ticodev.model.dto;

import java.util.Date;

public class MemberNotification {

    private int memberNum;
    private int notificationType;
    private int notificationNum;
    private Date datetime;
    private boolean isProcess;

    @Override
    public String toString() {
        return "MemberNotification{" +
                "memberNum=" + memberNum +
                ", type=" + notificationType +
                ", num=" + notificationNum +
                ", datetime=" + datetime +
                ", isProcess=" + isProcess +
                '}';
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public boolean isProcess() {
        return isProcess;
    }

    public void setProcess(boolean process) {
        isProcess = process;
    }

}
