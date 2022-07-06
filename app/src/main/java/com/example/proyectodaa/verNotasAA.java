package com.example.proyectodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyectodaa.db.dbHelper;

public class verNotasAA extends AppCompatActivity {
    Button b1,b2;
    EditText rut,asignatura;
    TextView notas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_notas_aa);
        b2=(Button) findViewById(R.id.b7_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(verNotasAA.this,interfazAlumno.class);
                startActivity(ir);
                finish();
            }
        });
        rut=(EditText)findViewById(R.id.string5);
        asignatura=(EditText)findViewById(R.id.string4);
        notas=(TextView) findViewById(R.id.notasTextView);
        b1=(Button) findViewById(R.id.b7_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper = new dbHelper(verNotasAA.this);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String comando = "SELECT notas FROM alumno WHERE rutAlumno='"+rut.getText().toString()+"'AND materia='"+asignatura.getText().toString()+"';";
                Cursor c = db.rawQuery(comando,null);
                if(c!=null){
                    c.moveToFirst();
                    notas.setText("");
                    do{
                        @SuppressLint("Range") String cadenilla = c.getString(c.getColumnIndex("notas"));
                        cadenilla = notas.getText().toString()+cadenilla+"\n";
                        notas.setText(cadenilla);
                    }while(c.moveToNext());
                    c.close();
                }
                rut.setText("");
                asignatura.setText("");

            }
        });
    }
}