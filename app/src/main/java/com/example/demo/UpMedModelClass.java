package com.example.demo;

public class UpMedModelClass {

    private String id,medname, startdate, enddate, days,time,userid;
    public UpMedModelClass(){
    }

    public UpMedModelClass(String id,String medname, String startdate, String enddate, String days,String time,String userid) {
        this.id=id;
        this.medname = medname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.days = days;
        this.time = time;
        this.userid = userid;
    }

    public String getMedName(){ return medname; }
    public void setMedName(String medname){ this.medname = medname; }
    public String getStartdate(){ return startdate; }
    public void setStartdate(String startdate){ this.startdate = startdate; }
    public String getEnddate(){ return enddate; }
    public void setEnddate(String enddate){ this.enddate = enddate; }
    public String getDays(){ return days; }
    public void setDays(String days){ this.days = days; }
    public String getTimeMed(){ return time; }
    public void setTimeMed(String time){ this.time = time; }
}
