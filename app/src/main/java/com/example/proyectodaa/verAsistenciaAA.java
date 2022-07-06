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

public class verAsistenciaAA extends AppCompatActivity {
    Button b1,b2;
    EditText rut;
    TextView asistencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_asistencia_aa);
        b2=(Button) findViewById(R.id.b9_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(verAsistenciaAA.this,interfazAlumno.class);
                startActivity(ir);
                finish();
            }
        });
        b1=(Button)findViewById(R.id.b9_1);
        rut=(EditText)findViewById(R.id.rutVerAsistencia);
        asistencia=(TextView) findViewById(R.id.asistenciaTextView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper = new dbHelper(verAsistenciaAA.this);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String comando = "SELECT asistio,fecha FROM asistencia WHERE rutAlumno='"+rut.getText().toString()+"';";
                Cursor c = db.rawQuery(comando,null);
                if(c!=null){
                    c.moveToFirst();
                    asistencia.setText("");
                    do{
                        @SuppressLint("Range") String cadenilla = c.getString(c.getColumnIndex("asistio"))+"      "+c.getString(c.getColumnIndex("fecha"));
                        cadenilla = asistencia.getText().toString()+cadenilla+"\n";
                        asistencia.setText(cadenilla);
                    }while(c.moveToNext());
                    c.close();
                }
                rut.setText("");
            }
        });
    }
}