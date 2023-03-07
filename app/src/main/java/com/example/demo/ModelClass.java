package com.example.demo;

public class ModelClass {
    private String id,docname, doccon, date, time,userid;
    public ModelClass(){
    }

    public ModelClass(String id,String docname, String doccon, String date, String time,String userid) {
        this.id=id;
        this.docname = docname;
        this.doccon = doccon;
        this.date = date;
        this.time = time;
        this.userid = userid;
    }

    public String getId() {
        return id.toString();
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDocname() {
        return docname;
    }
    public void setDocname(String docname) {
        this.docname = docname;
    }
    public String getDoccon() {
        return doccon;
    }
    public void setDoccon(String doccon) {
        this.doccon = doccon;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }


}
