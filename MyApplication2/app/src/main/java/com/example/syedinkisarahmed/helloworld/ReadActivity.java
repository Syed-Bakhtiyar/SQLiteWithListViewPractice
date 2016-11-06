package com.example.syedinkisarahmed.helloworld;

<<<<<<< HEAD
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
=======
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {

    TempRecord temp;
    SQLiteDatabase db;
    DataBase myclassdb;
    CrudClass crud;
    ListView listv;
    CustomListClass custom;
<<<<<<< HEAD
    Intent intent;

    AlertDialog.Builder build;
=======


>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e
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
<<<<<<< HEAD
        rec = crud.readData();





            custom = new CustomListClass(rec, getApplicationContext());
            listv.setAdapter(custom);

       build = new AlertDialog.Builder(this);
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                rec = crud.readData();



                build.setMessage("What you Wan't");
                build.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(getApplicationContext(),UpDateResult.class);


                        intent.putExtra("IDNUM",rec.get(position).getId());
                        Toast.makeText(ReadActivity.this, rec.get(position).getId()+ " Hello "+position, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                });
                build.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        intent = new Intent(getApplicationContext(),DeleteActivity.class);


                        intent.putExtra("IDDLTNUM",rec.get(position).getId());
                      //  Toast.makeText(ReadActivity.this, rec.get(position).getId()+ " Hello "+position, Toast.LENGTH_SHORT).show();
                        startActivity(intent);


                    }
                });
                build.show();


            }
        });

=======
        custom = new CustomListClass(crud.readData(),getApplicationContext());
        listv.setAdapter(custom);
>>>>>>> b9f51a388ce7a062177841f78fa5b11ce6b6343e


    }
}
