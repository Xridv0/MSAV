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

import com.example.proyectodaa.db.dbHelper;

public class loginProfesor extends AppCompatActivity {
    Button b1,b2;
    EditText id,contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_profesor);
        b1=(Button) findViewById(R.id.bloguin);
        b2=(Button) findViewById(R.id.bRetornar);
        id=(EditText)findViewById(R.id.idProfesor);
        contraseña=(EditText)findViewById(R.id.paswordProfesor);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir= new Intent(loginProfesor.this,MainActivity.class);
                startActivity(ir);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper = new dbHelper(loginProfesor.this);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String comando = "SELECT idProfesor,claveProfesor FROM profesores WHERE idProfesor='"+id.getText().toString()+"' AND claveProfesor= '"+contraseña.getText().toString()+"';";
                Cursor c = db.rawQuery(comando,null);
                c.moveToFirst();
                if(c.getCount()!=0){
                    @SuppressLint("Range") String idConsulta = c.getString(c.getColumnIndex("idProfesor"));
                    @SuppressLint("Range") String passConsulta = c.getString(c.getColumnIndex("claveProfesor"));
                    String idP = id.getText().toString();
                    String passP = contraseña.getText().toString();
                    if(idP.equals(idConsulta)&&passP.equals(passConsulta)){
                        Intent ir= new Intent(loginProfesor.this,interfazProfesor.class);
                        startActivity(ir);
                        finish();
                    }
                }else{
                    id.setText("");
                    contraseña.setText("");
                }

            }
        });
    }

}