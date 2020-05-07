package com.example.registroPersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

public class ListadoBuscar extends AppCompatActivity {

    ControladorRegistro c;
    ListView listado2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        listado2 = findViewById(R.id.listado2);
        c = new ControladorRegistro(getApplicationContext());
        String ced = getIntent().getStringExtra("cedula");
        Cursor cur = c.buscar(ced);

        CursorAdapterRegistroPersona eca = new CursorAdapterRegistroPersona(this,cur,0);
        listado2.setAdapter(eca);
        eca.notifyDataSetChanged();
    }

}
