package com.example.syedinkisarahmed.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {

    TempRecord temp;
    SQLiteDatabase db;
    DataBase myclassdb;
    CrudClass crud;
    ListView listv;
    CustomListClass custom;


    ArrayList<RecordForRead> rec;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);


        listv = (ListView) findViewById(R.id.list);
        myclassdb = new DataBase(this);

        rec = new ArrayList<RecordForRead>();
        db = myclassdb.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+DataBase.TABLE_NAME,null);
        crud = new CrudClass(c,rec);
        custom = new CustomListClass(crud.readData(),getApplicationContext());
        listv.setAdapter(custom);


    }
}
