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

public class ingresaAnotacionProfesor extends AppCompatActivity {
    Button b1,b2;
    EditText rut,anotacion;
    RadioButton rb1,rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresa_anotacion_profesor);
        b2=(Button) findViewById(R.id.b6_2);
        rut=(EditText)findViewById(R.id.editTextTextPersonName);
        anotacion=(EditText)findViewById(R.id.editTextTextMultiLine);
        rb1=(RadioButton)findViewById(R.id.radioButton6_1);
        rb2=(RadioButton)findViewById(R.id.radioButton6_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(ingresaAnotacionProfesor.this,interfazProfesor.class);
                startActivity(ir);
                finish();
            }
        });
        b1=(Button) findViewById(R.id.b6_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1.isChecked()){
                    System.out.println("entro");
                    String cadena = "positiva";
                    String comando = "INSERT into anotaciones(anotacion,rutAlumno,poN)VALUES('"+ anotacion.getText().toString() +"','"+rut.getText().toString()+"','"+cadena+"');";
                    dbHelper dbHelper = new dbHelper(ingresaAnotacionProfesor.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL(comando);
                }else if(rb2.isChecked()){
                    System.out.println("entro 2");
                    String cadena = "negativa";
                    String comando = "INSERT into anotaciones(anotacion,rutAlumno,poN)VALUES('"+ anotacion.getText().toString() +"','"+rut.getText().toString()+"','"+cadena+"');";
                    dbHelper dbHelper = new dbHelper(ingresaAnotacionProfesor.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL(comando);
                }
                rut.setText("");
                anotacion.setText("");
            }
        });
    }
}