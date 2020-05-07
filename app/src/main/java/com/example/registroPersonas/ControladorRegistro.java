package com.example.registroPersonas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ControladorRegistro {

    private BD db;

    public ControladorRegistro(Context context) {
        this.db = new BD(context);
    }

    public long agregarPersona(registroPersona e){
        try{

            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(esquemaBD.columna_cedula, e.cedula);
            valores.put(esquemaBD.columna_nombre, e.nombre);
            valores.put(esquemaBD.columna_estrato, e.estrato);
            valores.put(esquemaBD.columna_salario, e.salario);
            valores.put(esquemaBD.columna_nivel, e.nivel);

            long id = database.insert(esquemaBD.tabla_registro,null, valores);
            return id;
        }
        catch (Exception ex){
            System.out.println("Error");
            return 0;
        }
    }

    public boolean buscarPersona(String cedula){
        String[] args = new String[] {cedula};
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query(esquemaBD.tabla_registro, null, "cedula=?", args, null, null, null);
        if (c.getCount()>0) {
            database.close();
            return true;
        }
        else{
            database.close();
            return false;}
    }

    public void eliminarPersona(String ced){
            SQLiteDatabase database = db.getReadableDatabase();
            database.execSQL("DELETE FROM registro_personas where cedula=?", new String[]{ced});
    }

    public long actualizarPersona(registroPersona e){
        try{
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            String[] args = new String[] {e.cedula};
            valores.put(esquemaBD.columna_nombre, e.nombre);
            valores.put(esquemaBD.columna_estrato, e.estrato);
            valores.put(esquemaBD.columna_salario, e.salario);
            valores.put(esquemaBD.columna_nivel, e.nivel);
            long id = database.update(esquemaBD.tabla_registro, valores,"cedula=?",args);
            database.close();
            return id;
        }
        catch (Exception ex){
            System.out.println("Error");
            return 0;
        }

    }


    public Cursor mostrarTodos() {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cur = database.rawQuery("select cedula as _id, nombre, estrato, salario, nivel from registro_personas", null);
            return cur;
        } catch (Exception ex) {
            System.out.println("Error");
            return null;
        }
    }

    public Cursor buscar(String cedula) {
        String[] ced = new String[] {cedula};
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cur3 = database.rawQuery("select cedula as _id, nombre, estrato, salario, nivel from registro_personas where cedula=?",ced , null);
            return cur3;
        } catch (Exception ex) {
            System.out.println("Error");
            return null;
        }
    }

}