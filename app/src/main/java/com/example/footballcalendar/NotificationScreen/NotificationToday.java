package com.example.footballcalendar.NotificationScreen;

public class NotificationToday {

    private int resoureId1 , resoureId2;
    private String des, time;


    public NotificationToday(int resoureId1, int resoureId2, String des, String time) {
        this.resoureId1 = resoureId1;
        this.resoureId2 = resoureId2;
        this.des = des;
        this.time = time;
    }

    public int getResoureId1() {
        return resoureId1;
    }

    public void setResoureId1(int resoureId1) {
        this.resoureId1 = resoureId1;
    }

    public int getResoureId2() {
        return resoureId2;
    }

    public void setResoureId2(int resoureId2) {
        this.resoureId2 = resoureId2;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}


