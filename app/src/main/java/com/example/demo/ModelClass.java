package com.example.demo;

public class ModelClass {
    private String docname, doccon, date, time;
    public ModelClass(){
    }

    public ModelClass(String docname, String doccon, String date, String time) {
        this.docname = docname;
        this.doccon = doccon;
        this.date = date;
        this.time = time;
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
