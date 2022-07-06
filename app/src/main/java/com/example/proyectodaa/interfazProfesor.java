package com.example.proyectodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class interfazProfesor extends AppCompatActivity {
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_profesor);
        b4=(Button)findViewById(R.id.b2_4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(interfazProfesor.this,MainActivity.class);
                startActivity(ir);
                finish();
            }
        });
        b1=(Button) findViewById(R.id.b2_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(interfazProfesor.this,ingresaNotaProfesor.class);
                startActivity(ir);
                finish();
            }
        });
        b2=(Button) findViewById(R.id.b2_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(interfazProfesor.this,ingresaAsistenciaProfesor.class);
                startActivity(ir);
                finish();
            }
        });
        b3=(Button) findViewById(R.id.b2_3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(interfazProfesor.this,ingresaAnotacionProfesor.class);
                startActivity(ir);
                finish();
            }
        });
    }
}