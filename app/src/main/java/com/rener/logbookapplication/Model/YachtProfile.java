package com.rener.logbookapplication.Model;

public class YachtProfile {

    private String name;

    public YachtProfile() {}

    private String length;
    private String year;
    private String marina;
    private String box;

    public YachtProfile(String name, String length, String year, String marina, String box) {
        this.name = name;
        this.length = length;
        this.year = year;
        this.marina = marina;
        this.box = box;
    }




    public String getName() {
        return name;
    }

    public String getLength() {
        return length;
    }

    public String getYear() {
        return year;
    }

    public String getMarina() {
        return marina;
    }

    public String getBox() {
        return box;
    }

//    public String getUserid() {
//        return userid;
//    }

//    public void setUserid(String userid) {
//        this.userid = userid;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMarina(String marina) {
        this.marina = marina;
    }

    public void setBox(String box) {
        this.box = box;
    }
}

