package com.example.proyectodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class interfazAlumno extends AppCompatActivity {
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_alumno);
        b4=(Button)findViewById(R.id.b3_4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(interfazAlumno.this,MainActivity.class);
                startActivity(ir);
                finish();
            }
        });
        b1=(Button) findViewById(R.id.b3_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(interfazAlumno.this,verNotasAA.class);
                startActivity(ir);
                finish();
            }
        });
        b3=(Button) findViewById(R.id.b3_3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(interfazAlumno.this,verAnotacionesAA.class);
                startActivity(ir);
                finish();
            }
        });
        b2=(Button) findViewById(R.id.b3_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(interfazAlumno.this,verAsistenciaAA.class);
                startActivity(ir);
                finish();
            }
        });
    }
}