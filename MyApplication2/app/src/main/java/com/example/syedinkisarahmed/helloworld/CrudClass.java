package com.example.syedinkisarahmed.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e

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

<<<<<<< HEAD
    public CrudClass() {

    }

=======
>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e
    public CrudClass(Cursor cur, ArrayList<RecordForRead> record) {
        this.cur = cur;
        this.record = record;

    }

    public CrudClass(SQLiteDatabase db, TempRecord rec, Context c) {
        this.db = db;
        this.rec=rec;
        this.c=c;
    }

<<<<<<< HEAD
    /*

        For Insert

     */

=======
>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e
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

<<<<<<< HEAD
    /*

                For Read

     */

=======
>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e

    public ArrayList<RecordForRead> readData(){
        String Id;
        String tempName;
        String subjName;
        int total, gain;



<<<<<<< HEAD

        while(cur.moveToNext()){

=======
        while(cur.moveToNext()){
>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e
            Id = cur.getString(cur.getColumnIndex(DataBase.ID));
           tempName = cur.getString(cur.getColumnIndex(DataBase.STUDENT_NAME));
            subjName = cur.getString(cur.getColumnIndex(DataBase.SUBJECT_NAME));
            total = Integer.parseInt( cur.getString(cur.getColumnIndex(DataBase.Total_Marks)));
            gain = Integer.parseInt( cur.getString(cur.getColumnIndex(DataBase.Gained_Marks)));

            record.add(new RecordForRead(Id,tempName,subjName,total,gain));


        }


<<<<<<< HEAD

=======
>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e
        return this.record;
    }


<<<<<<< HEAD
/*

                        For Update

 */










    public void updateStrings(int check, String rcv, String Id, SQLiteDatabase db,Context context) {


        values = new ContentValues();
        this.db = db;
        if (check == 1) {
            Toast.makeText(context, Id, Toast.LENGTH_SHORT).show();
            values.put(DataBase.STUDENT_NAME, rcv);
            db.update(DataBase.TABLE_NAME, values, DataBase.ID +" = "+ Id, null);

        } else if (check == 2) {

            values.put(DataBase.SUBJECT_NAME, rcv);
            db.update(DataBase.TABLE_NAME, values, DataBase.ID +" = "+ Id, null);


        }

    }



    public void updateNumbers(int check, int rcv, String Id, SQLiteDatabase db){

        values = new ContentValues();
        this.db =db;
        if(check ==1){
            values.put(DataBase.Total_Marks,rcv);
            db.update(DataBase.TABLE_NAME,values,DataBase.ID +" = "+ Id,null);

        }
        else if(check==2){

            values.put(DataBase.Gained_Marks,rcv);
            db.update(DataBase.TABLE_NAME,values,DataBase.ID +" = "+ Id,null);


        }


    }



    /*

            For Delete

     */

    public void deleteRecord(String Id, SQLiteDatabase db){

        db.delete(DataBase.TABLE_NAME,DataBase.ID+" = "+Id,null);


    }




=======
>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e


}
