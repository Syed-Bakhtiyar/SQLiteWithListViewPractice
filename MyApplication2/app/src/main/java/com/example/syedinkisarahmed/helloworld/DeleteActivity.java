package com.example.syedinkisarahmed.helloworld;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    Bundle bundle;
    CrudClass crud;
    SQLiteDatabase db;
    DataBase mydb;
    String ID;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        bundle = getIntent().getExtras();
        ID = bundle.getString("IDDLTNUM");

        btn = (Button) findViewById( R.id.delete);

        mydb = new DataBase(this);
        db = mydb.getWritableDatabase();
        crud = new CrudClass();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                crud.deleteRecord(ID,db);
                Toast.makeText(DeleteActivity.this, "Deleted", Toast.LENGTH_SHORT).show();


            }
        });




    }
}
