package com.example.proyectodaa.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

import androidx.annotation.Nullable;

public class dbalumnos extends dbHelper{
    Context context;
    public dbalumnos(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertaNotasAlumno(String rut, Float nota, String asignatura){
        dbHelper dbHelper = new dbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("rutAlumno",rut);
        values.put("notas",nota);
        values.put("materia",asignatura);

        long id = db.insert("alumno",null,values);
        return id;

    }
}
