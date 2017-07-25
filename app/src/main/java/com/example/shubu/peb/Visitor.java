package com.example.shubu.peb;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Math.abs;

/**
 * Created by laptop on 23-07-2017.
 */

public class Visitor implements Serializable {
    public String name;
    public String info;
    public String date;
    public String in_time;
    public String out_time;
    public String duration;
    public String service;
    public String guard;

    public Visitor(){}
    public Visitor(String name,String info,String date,String in_time,String out_time,String duration,String service,String guard) {
        //this.sno=sno;
        this.name=name;
        this.info=info;
        this.date=date;
        this.in_time=in_time;
        this.out_time=out_time;
        this.duration=duration;
        this.service=service;
        this.guard=guard;
    }

    public void setVisitorName(String name){
        this.name=name;
    }
    public void setInfo(String info){
        this.info=info;
    }
    public void setDate(String date){
        this.date=date;
    }
    public void setIn_time(String in_time){
        this.in_time=in_time;
    }
    public void setOut_time(String out_time){
        this.out_time=out_time;
    }
    public void setDuration(String duration){
        this.duration=duration;
    }
    public void setService(String service){
        this.service=service;
    }
    public void setGuard(String guard){
        this.guard=guard;
    }
    public String getVisitorName(){return this.name;}
    public String getInfo(){return this.info;}
    public String getDate(){return this.date;}
    public String getIn_time(){return this.in_time;}
    public String getOut_time(){return this.out_time;}
    public String getDuration(){return this.duration;}
    public String getService(){return this.service;}
    public String getGuard(){return this.guard;}

}
