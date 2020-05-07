package com.example.registroPersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

public class ListadoActivity extends AppCompatActivity {

    ControladorRegistro c;
    ListView listado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        listado = findViewById(R.id.listado2);
        c = new ControladorRegistro(getApplicationContext());

        Cursor cur = c.mostrarTodos();

        CursorAdapterRegistroPersona eca = new CursorAdapterRegistroPersona(this,cur,0);
        listado.setAdapter(eca);
        eca.notifyDataSetChanged();
    }







}
