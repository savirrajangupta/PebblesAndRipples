package com.example.shubu.peb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Complet_visitor_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complet_visitor_details);
       Visitor visitor=(Visitor) getIntent().getSerializableExtra("myobject");
        TextView vi_name= (TextView) findViewById(R.id.vistor_name);
        TextView vi_info= (TextView) findViewById(R.id.vistor_info);
         TextView vi_service=(TextView) findViewById(R.id.visitor_service);
        TextView vi_date= (TextView) findViewById(R.id.visit_date);
        TextView vi_in_time= (TextView) findViewById(R.id.in_time);
        TextView vi_out_time= (TextView) findViewById(R.id.out_time);
        TextView vi_duration= (TextView) findViewById(R.id.duration);
        TextView vi_gaurd= (TextView) findViewById(R.id.gaurd);

        String resi="<b>Name:</b> "+visitor.getVisitorName();
        vi_name.setText(Html.fromHtml(resi));
        resi="<b>Job:</b> "+visitor.getService();
        vi_service.setText(Html.fromHtml(resi));
        resi="<b>V_info:</b> "+visitor.getInfo();
        vi_info.setText(Html.fromHtml(resi));
        resi="<b>Date:</b> "+visitor.getDate();
        vi_date.setText(Html.fromHtml(resi));
        resi="<b>In time:</b> "+visitor.getIn_time();
        vi_in_time.setText(Html.fromHtml(resi));
        resi="<b>Out time:</b> "+visitor.getOut_time();
        vi_out_time.setText(Html.fromHtml(resi));
        resi="<b>Duration:</b> "+visitor.getDuration();
        vi_duration.setText(Html.fromHtml(resi));
        resi="<b>Gaurd:</b> "+visitor.getGuard();
        vi_gaurd.setText(Html.fromHtml(resi));

    }
}
