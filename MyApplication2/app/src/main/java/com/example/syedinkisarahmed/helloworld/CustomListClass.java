package com.example.syedinkisarahmed.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bakhtiyar on 11/1/2016.
 */
public class CustomListClass extends BaseAdapter {
    ArrayList<RecordForRead> record;
    LayoutInflater inflate;
    Context con;

    TextView id,name,subjname,total,gain;

    public CustomListClass(ArrayList<RecordForRead> record, Context con) {
        this.record = record;
        this.inflate = inflate.from(con);
        this.con = con;
    }

    @Override
    public int getCount() {
        return record.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



         View v = inflate.inflate(R.layout.list_view_structure, parent, false);

          id = (TextView) v.findViewById(R.id.Id);
          id.setText(record.get(position).getId());

          name = (TextView) v.findViewById(R.id.name);
          name.setText(record.get(position).getName());

          subjname = (TextView) v.findViewById(R.id.subjname);
          subjname.setText(record.get(position).getSubName());

          total = (TextView) v.findViewById(R.id.total);
          total.setText(record.get(position).getMarks());

        //  gain = (TextView) v.findViewById(R.id.gain);
       //   gain.setText(""+record.get(position).getGainMarks());

          return v;


      }
}
