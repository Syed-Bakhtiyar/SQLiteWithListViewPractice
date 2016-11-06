package com.example.syedinkisarahmed.helloworld;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpDateResult extends AppCompatActivity {
    SQLiteDatabase db;
    DataBase mydb;
    ContentValues value;

    String Id;
    String name ="";
    String subjName ="";
    int total =-1;
    int gain =-1;

    CrudClass crud;
    Bundle extra;

    TextView txtname,txtsubj,txttotal,txtgain;
    Button btnName,btnSubj,btnTotal,btnGain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_date_result);

        extra =getIntent().getExtras();
        Id = extra.getString("IDNUM");


        mydb = new DataBase(this);
        db = mydb.getWritableDatabase();

        btnName = (Button) findViewById( R.id.UpDatename);
        btnSubj = (Button) findViewById( R.id.UpDatesubj);
        btnTotal = (Button) findViewById( R.id.UpDatetotal);
        btnGain = (Button) findViewById( R.id.UpDategain);

        txtname = (TextView) findViewById(R.id.upname);
        txtsubj = (TextView) findViewById(R.id.upsubject);
        txttotal = (TextView) findViewById(R.id.uptotalMarks);
        txtgain = (TextView) findViewById(R.id.upgainmarks);

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtname.getText().toString();
                if(name==""){
                    Toast.makeText(UpDateResult.this, "Please type name for update", Toast.LENGTH_SHORT).show();
                    txtname.setText("");
                }else {

                    crud = new CrudClass();

                    crud.updateStrings(1,name,Id,db,getApplicationContext());

                }





            }
        });

        btnSubj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjName = txtsubj.getText().toString();
                if(subjName==""){
                    Toast.makeText(UpDateResult.this, "Please type Subj name for update", Toast.LENGTH_SHORT).show();
                    txtsubj.setText("");
                }else {

                    crud = new CrudClass();
                    crud.updateStrings(2,subjName,Id,db,getApplicationContext());
                }


            }
        });

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    total = Integer.parseInt(txttotal.getText().toString());
                    if (total == -1) {
                        Toast.makeText(UpDateResult.this, "Please type Total Number for update", Toast.LENGTH_SHORT).show();
                        txtname.setText("");
                    } else {
                        crud = new CrudClass();
                        crud.updateNumbers(1,total,Id,db);

                    }
                }catch (Exception ex){

                    Toast.makeText(UpDateResult.this, ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    gain = Integer.parseInt(txtgain.getText().toString());
                    if (gain == -1) {
                        Toast.makeText(UpDateResult.this, "Please type Gain Number for update", Toast.LENGTH_SHORT).show();
                        txtname.setText("");
                    } else {


                        crud = new CrudClass();
                        crud.updateNumbers(2,gain,Id,db);
                    }
                }catch (Exception ex){

                    Toast.makeText(UpDateResult.this, ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
