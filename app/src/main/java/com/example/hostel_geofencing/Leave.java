package com.example.hostel_geofencing;

public class Leave {

    String sname,pnumber,date,reason,status;

    public Leave() {
    }

    public Leave(String sname, String pnumber, String date, String reason, String status) {
        this.sname = sname;
        this.pnumber = pnumber;
        this.date = date;
        this.reason = reason;
        this.status = status;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
