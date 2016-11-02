package com.example.syedinkisarahmed.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bakhtiyar on 10/31/2016.
 */
public class DataBase extends SQLiteOpenHelper {
    public static final String  DB_NAME ="MyDb.db";
    public static final int VERSION =2;

    public static String TABLE_NAME ="Students";

    public static final String ID = "_id";
    public static final String STUDENT_NAME = "Student_Name";
    public static final String SUBJECT_NAME = "SUBJECT_Name";
    public static final String Total_Marks = "Total_Marks";
    public static final String Gained_Marks = "Gain_Marks";

    public DataBase(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+TABLE_NAME+"( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+SUBJECT_NAME+" TEXT, "+STUDENT_NAME+" TEXT NOT NULL,"+Total_Marks+" INTEGER DEFAULT 100,"+Gained_Marks+" INTEGER DEFAULT 0) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }



}
