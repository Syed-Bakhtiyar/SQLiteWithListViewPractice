package com.example.syedinkisarahmed.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Bakhtiyar on 10/31/2016.
 */
public class CrudClass {
    SQLiteDatabase db;
    ContentValues values;
    TempRecord rec;
    Context c;
    Cursor cur;
    ArrayList<RecordForRead> record;

    public CrudClass(Cursor cur, ArrayList<RecordForRead> record) {
        this.cur = cur;
        this.record = record;

    }

    public CrudClass(SQLiteDatabase db, TempRecord rec, Context c) {
        this.db = db;
        this.rec=rec;
        this.c=c;
    }

    public boolean insertData(){

        this.values = new ContentValues();
        values.put(DataBase.SUBJECT_NAME,this.rec.getSubName());
        values.put(DataBase.STUDENT_NAME,this.rec.getName());
        values.put(DataBase.Total_Marks,this.rec.getTotalMarks());
        values.put(DataBase.Gained_Marks,this.rec.getGainMarks());
        long flag = this.db.insert(DataBase.TABLE_NAME,null,this.values);
     //   Toast.makeText(c,rec.getName() , Toast.LENGTH_SHORT).show();
        if(flag == -1){
            return false;

        }
        else {
            return true;

        }


    }


    public ArrayList<RecordForRead> readData(){
        String Id;
        String tempName;
        String subjName;
        int total, gain;



        while(cur.moveToNext()){
            Id = cur.getString(cur.getColumnIndex(DataBase.ID));
           tempName = cur.getString(cur.getColumnIndex(DataBase.STUDENT_NAME));
            subjName = cur.getString(cur.getColumnIndex(DataBase.SUBJECT_NAME));
            total = Integer.parseInt( cur.getString(cur.getColumnIndex(DataBase.Total_Marks)));
            gain = Integer.parseInt( cur.getString(cur.getColumnIndex(DataBase.Gained_Marks)));

            record.add(new RecordForRead(Id,tempName,subjName,total,gain));


        }


        return this.record;
    }




}
