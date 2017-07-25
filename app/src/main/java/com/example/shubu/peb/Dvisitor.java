package com.example.shubu.peb;


/**
 * Created by laptop on 24-07-2017.
 */

public class Dvisitor {
    public String visitor_id;
    public String dv_name;   //visitor name
    public String visited_to;
    public String reason;
    public String service;
    public String v_no;  //vehicle number
    public Dvisitor(){}
public Dvisitor(String visitor_id,String dv_name,String visited_to,String reason,String service,String v_no){
    this.visitor_id=visitor_id;
    this.visited_to=visited_to;
    this.dv_name=dv_name;
    this.reason=reason;
    this.service=service;
    this.v_no=v_no;
}
}
