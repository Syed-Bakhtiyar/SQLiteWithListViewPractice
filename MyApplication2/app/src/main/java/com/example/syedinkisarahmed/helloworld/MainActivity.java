package com.example.syedinkisarahmed.helloworld;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtSubj,txtTotal,txtGained;
    String name, subName;
    int totalMarks, gainedMarks;

    int count =0;

    Button submit, read;

    TempRecord temp;
    SQLiteDatabase db;
    DataBase myclassdb;
    CrudClass crud;
    ContentValues values;


    ArrayList<TempRecord> rec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myclassdb = new DataBase(getApplicationContext());

        db = myclassdb.getWritableDatabase();
        values= new ContentValues();
        txtName = (EditText) findViewById(R.id.name);
        txtSubj = (EditText) findViewById(R.id.subject);
        txtTotal = (EditText) findViewById(R.id.totalMarks);
        txtGained = (EditText) findViewById(R.id.gainmarks);
        submit = (Button) findViewById(R.id.submit);
        read = (Button) findViewById(R.id.read);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                        count++;
                    name = txtName.getText().toString();

                    subName = txtSubj.getText().toString();

                    totalMarks = Integer.parseInt(txtTotal.getText().toString());

                    gainedMarks = Integer.parseInt(txtGained.getText().toString());

                    temp = new TempRecord(name,subName,totalMarks,gainedMarks);



                   crud = new CrudClass(db,temp,getApplication());







                    if(crud.insertData()){
                        Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();

                    }













                }   catch (Exception e){

                    Toast.makeText(MainActivity.this, e.toString()+" "+count, Toast.LENGTH_SHORT).show();


                }





            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),ReadActivity.class));




            }
        });


    }
}
