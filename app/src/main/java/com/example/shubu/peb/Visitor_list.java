package com.example.shubu.peb;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by laptop on 23-07-2017.
 */

public class Visitor_list extends ArrayAdapter<Visitor> {
    private Activity context;
    List<Visitor> visitorList;
    public Visitor_list(Activity context, List<Visitor> visitorList){
        super(context,R.layout.list_layout,visitorList);
        this.context=context;
        this.visitorList=visitorList;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflator=context.getLayoutInflater();
        View listViewItem=inflator.inflate(R.layout.list_layout,null,true);
        TextView vi_name= (TextView) listViewItem.findViewById(R.id.vistor_name);
        TextView vi_info= (TextView) listViewItem.findViewById(R.id.vistor_info);
        TextView vi_date= (TextView) listViewItem.findViewById(R.id.visit_date);
        Visitor visitor=visitorList.get(position);
        vi_name.setText(visitor.getVisitorName());
        vi_info.setText(visitor.getInfo());
        vi_date.setText(visitor.getDate());
        return listViewItem;
    }


}
