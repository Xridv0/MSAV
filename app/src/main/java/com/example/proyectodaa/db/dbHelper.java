package com.example.proyectodaa.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME= "colegio";
    private static final String TABLE_PERSONA= "persona";
    private static final String TABLE_ASISTENCIA= "asistencia";
    private static final String TABLE_ALUMNO= "alumno";
    private static final String TABLE_ANOTACIONES= "anotaciones";
    private static final String TABLE_PROFESORES= "profesores";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_PERSONA + "(" +
                "rut TEXT PRIMARY KEY ," +
                "nombre TEXT ," +
                "direccion TEXT ," +
                "sexo TEXT ," +
                "f_nac DATE )" );
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_ALUMNO+"(" +
                "notas FLOAT ," +
                "rutAlumno TEXT ," +
                "materia TEXT ," +
                "apoderado TEXT )");
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_ANOTACIONES+ "(" +
                "anotacion TEXT ," +
                "rutAlumno TEXT ," +
                "poN TEXT )");
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_ASISTENCIA+"(" +
                "rutAlumno TEXT," +
                "asistio TEXT," +
                "fecha TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_PROFESORES+"(" +
                "idProfesor TEXT," +
                "claveProfesor TEXT)");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_PROFESORES+"(idProfesor,claveProfesor)VALUES('19594216-1','admin');");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_PROFESORES+"(idProfesor,claveProfesor)VALUES('9647217-k','profesor');");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_PROFESORES+"(idProfesor,claveProfesor)VALUES('admin','admin');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
