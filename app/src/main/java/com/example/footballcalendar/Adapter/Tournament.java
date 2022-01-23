package com.example.footballcalendar.Adapter;

public class Tournament {

    private int resoureId;
    private String name;

    public Tournament(int resoureId, String name) {
        this.resoureId = resoureId;
        this.name = name;
    }

    public int getResoureId() {
        return resoureId;
    }

    public void setResoureId(int resoureId) {
        this.resoureId = resoureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
