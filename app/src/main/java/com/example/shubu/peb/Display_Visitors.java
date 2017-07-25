package com.example.shubu.peb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Display_Visitors extends AppCompatActivity {
    ListView listViewVisitors;
    String vi_info;
    Visitor visitor;
    private List<Visitor> visitorlist;
    private DatabaseReference databasepebble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_visitors);
        listViewVisitors = (ListView) findViewById(R.id.visitor_listview);
        listViewVisitors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Visitor visitor2 = visitorlist.get(position);
                Intent intent=new Intent(Display_Visitors.this,Complet_visitor_details.class);
                intent.putExtra("myobject",visitor2);
                startActivity(intent);
            }
        });

        databasepebble = FirebaseDatabase.getInstance().getReference();
        visitorlist = new ArrayList<Visitor>();
        TextView tv= (TextView) findViewById(R.id.mtext);
        String data="List of Visitors";
        SpannableString content=new SpannableString(data);
        content.setSpan(new UnderlineSpan(),0,data.length(),0);
        tv.setText(content);

    }

    @Override
    protected void onStart() {
        super.onStart();

        databasepebble.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                visitorlist.clear();
                DataSnapshot dataSnapshot1 = dataSnapshot.child("dvisits");
                DataSnapshot dataSnapshot2 = dataSnapshot.child("dvisitor");
                for (DataSnapshot postSnapshot : dataSnapshot1.getChildren()) {
                    final Visit visit = postSnapshot.getValue(Visit.class);
                    if (!visit.resident) {
                        String visitor_id = visit.visitor_id;
                        DataSnapshot dataSnapshot3 = dataSnapshot2.child(visitor_id);
                        Dvisitor dvisitor = dataSnapshot3.getValue(Dvisitor.class);
                        Log.d("list1", "printing " + dvisitor.dv_name);
                        if (dvisitor.reason.equals("service")) {
                            if (visit.means.equals("by self"))
                                vi_info = "by self";
                            else
                                vi_info = dvisitor.v_no;
                            visitor = new Visitor(dvisitor.dv_name, vi_info, visit.date, visit.in_time, visit.out_time, visit.duration, dvisitor.service, visit.gaurd);
                            visitorlist.add(visitor);
                        }
                    }
                }

                Visitor_list visitorAdapter = new Visitor_list(Display_Visitors.this, visitorlist);
                //attaching adapter to the listview
                listViewVisitors.setAdapter(visitorAdapter);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}