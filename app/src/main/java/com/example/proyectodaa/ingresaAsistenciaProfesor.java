package com.example.proyectodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.proyectodaa.db.dbHelper;

public class ingresaAsistenciaProfesor extends AppCompatActivity {
    Button b1,b2;
    RadioButton rb1,rb2;
    EditText rut,fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresa_asistencia_profesor);
        b2=(Button) findViewById(R.id.b5_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(ingresaAsistenciaProfesor.this,interfazProfesor.class);
                startActivity(ir);
                finish();
            }
        });
        rut=(EditText)findViewById(R.id.string3);
        fecha=(EditText)findViewById(R.id.date5_1);
        rb1=(RadioButton)findViewById(R.id.radioButton5_1);
        rb2=(RadioButton)findViewById(R.id.radiobutton5_2);
        b1=(Button) findViewById(R.id.b5_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1.isChecked()){
                    String asistencia = "si";
                    String comando = "INSERT into asistencia(rutAlumno,asistio,fecha)VALUES('"+ rut.getText().toString() +"','"+asistencia+"','"+fecha.getText().toString()+"');";
                    dbHelper dbHelper = new dbHelper(ingresaAsistenciaProfesor.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL(comando);
                }else if(rb2.isChecked()){
                    String asistencia = "no";
                    String comando = "INSERT into asistencia(rutAlumno,asistio,fecha)VALUES('"+ rut.getText().toString() +"','"+asistencia+"','"+fecha.getText().toString()+"');";
                    dbHelper dbHelper = new dbHelper(ingresaAsistenciaProfesor.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL(comando);
                }
                rut.setText("");
                fecha.setText("");
            }
        });
    }
}