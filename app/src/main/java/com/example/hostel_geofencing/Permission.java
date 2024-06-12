package com.example.hostel_geofencing;

public class Permission {

    String sname,pnumer,day,reason,status;

    public Permission() {
    }

    public Permission(String sname, String pnumer, String day, String reason, String status) {
        this.sname = sname;
        this.pnumer = pnumer;
        this.day = day;
        this.reason = reason;
        this.status = status;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPnumer() {
        return pnumer;
    }

    public void setPnumer(String pnumer) {
        this.pnumer = pnumer;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
