package com.example.proyectodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyectodaa.db.dbHelper;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(MainActivity.this,loginProfesor.class);
                startActivity(ir);
                finish();
            }
        });
        b2=(Button)findViewById(R.id.b1_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(MainActivity.this,interfazAlumno.class);
                startActivity(ir);
                finish();
            }
        });
        b4=(Button) findViewById(R.id.b1_4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper =  new dbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
            }
        });

    }
}