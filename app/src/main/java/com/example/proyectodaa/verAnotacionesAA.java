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

public class verAnotacionesAA extends AppCompatActivity {
    Button b1,b2;
    EditText rut;
    TextView anotaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_anotaciones_aa);
        b2=(Button) findViewById(R.id.b8_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(verAnotacionesAA.this,interfazAlumno.class);
                startActivity(ir);
                finish();
            }
        });
        rut=(EditText)findViewById(R.id.string6);
        anotaciones=(TextView)findViewById(R.id.textView);
        b1=(Button) findViewById(R.id.b8_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper = new dbHelper(verAnotacionesAA.this);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String comando = "SELECT anotacion,poN FROM anotaciones WHERE rutAlumno='"+rut.getText().toString()+"';";
                Cursor c = db.rawQuery(comando,null);
                if(c!=null){
                    c.moveToFirst();
                    anotaciones.setText("");
                    do{
                        @SuppressLint("Range") String cadenilla = c.getString(c.getColumnIndex("anotacion"))+"      "+c.getString(c.getColumnIndex("poN"));
                        cadenilla = anotaciones.getText().toString()+cadenilla+"\n";
                        anotaciones.setText(cadenilla);
                    }while(c.moveToNext());
                    c.close();
                }
                rut.setText("");
            }
        });
    }
}