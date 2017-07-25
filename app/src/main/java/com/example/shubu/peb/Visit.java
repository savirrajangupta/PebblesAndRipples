package com.example.shubu.peb;

/**
 * Created by laptop on 24-07-2017.
 */

public class Visit
{
    public String visit_id;
    public String visitor_id;
    public String v_name;  //visitor name
    public String vehicle_no;
    public String means;  //byfoot or vehicle
    public Boolean resident; //if true->resident false->visitor
    public String in_time;
    public String gaurd;
    public String out_time;
    public String duration;
    public String date;
    public Visit(){}
    public Visit(String visit_id,String visitor_id,String v_name,String vehicle_no,String means,Boolean resident,String in_time,String gaurd,String out_time,String duration,String date){
        this.visit_id=visit_id;
        this.visitor_id=visitor_id;
        this.v_name=v_name;
        this.vehicle_no=vehicle_no;
        this.means=means;
        this.resident=resident;
        this.in_time=in_time;
        this.gaurd=gaurd;
        this.out_time=out_time;
        this.duration=duration;
        this.date=date;
    }
}
