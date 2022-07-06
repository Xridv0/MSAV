package com.example.proyectodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectodaa.db.dbalumnos;

public class ingresaNotaProfesor extends AppCompatActivity {
    Button b1,b2;
    EditText rut,nota,asignatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresa_nota_profesor);
        b2=(Button)findViewById(R.id.b4_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(ingresaNotaProfesor.this,interfazProfesor.class);
                startActivity(ir);
                finish();
            }
        });
        rut=(EditText)findViewById(R.id.string2);
        nota=(EditText)findViewById(R.id.number2);
        asignatura=(EditText)findViewById(R.id.string1);
        String string = String.valueOf(rut.getText());


        b1=(Button)findViewById(R.id.b4_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbalumnos dbalumnos = new dbalumnos(ingresaNotaProfesor.this);
                SQLiteDatabase db = dbalumnos.getWritableDatabase();
                System.out.println(rut.getText());
                System.out.println(nota.getText());
                Float number = Float.valueOf(nota.getText().toString());
                number = number/10;
                System.out.println(asignatura.getText());
                String consulta = "INSERT into alumno(notas,rutAlumno,materia,apoderado)VALUES("+ number +",'"+rut.getText().toString()+"','"+asignatura.getText().toString()+"','-');";
                db.execSQL(consulta);
                rut.setText("");
                nota.setText("");
                asignatura.setText("");

            }
        });
    }
}