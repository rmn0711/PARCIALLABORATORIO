package com.example.registroPersonas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.registroPersonas.R.id.edtcedula;


public class MainActivity extends AppCompatActivity {

    Spinner est, lvl;
    EditText ce, nom, sal;
    registroPersona regis;
    ControladorRegistro c;
    Button guardar, listado, eliminar, actualizar, buscar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ce = findViewById(edtcedula);
        nom = findViewById(R.id.edtnombre);
        est = findViewById(R.id.spinnerestrato);
        sal = findViewById(R.id.edtsalario);
        lvl = findViewById(R.id.spinnernivel);
        guardar = findViewById(R.id.btnguardar);
        eliminar = findViewById(R.id.btneliminar);
        actualizar = findViewById(R.id.btnactualizar);
        listado = findViewById(R.id.btnlistado);
        buscar = findViewById(R.id.btnbuscar);

        c = new ControladorRegistro(getApplicationContext());

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regis = new registroPersona(ce.getText().toString(), nom.getText().toString(),
                        est.getItemAtPosition(est.getFirstVisiblePosition()).toString(),
                        sal.getText().toString(),
                        lvl.getItemAtPosition(lvl.getFirstVisiblePosition()).toString());
                if(!c.buscarPersona(regis.cedula)) {
                    long id = c.agregarPersona(regis);
                    Toast.makeText(getApplicationContext(), "Persona guardada exitosamente", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"La persona ya está registrada",Toast.LENGTH_SHORT).show();
                }
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regis = new registroPersona(ce.getText().toString(), nom.getText().toString(),
                        est.getItemAtPosition(est.getFirstVisiblePosition()).toString(),
                        sal.getText().toString(),
                        lvl.getItemAtPosition(lvl.getFirstVisiblePosition()).toString());
        if (c.buscarPersona(regis.cedula)) {
            c.eliminarPersona(regis.cedula);
            Toast.makeText(getApplicationContext(), "Persona eliminada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "La persona no está registrada", Toast.LENGTH_SHORT).show();
        }

            }
        });

        listado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListadoActivity.class);
                startActivity(i);
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regis = new registroPersona(ce.getText().toString(), nom.getText().toString(),
                        est.getItemAtPosition(est.getFirstVisiblePosition()).toString(),
                        sal.getText().toString(),
                        lvl.getItemAtPosition(lvl.getFirstVisiblePosition()).toString());
                if(c.buscarPersona(regis.cedula)){
                    Intent i = new Intent(MainActivity.this, ListadoBuscar.class);
                    i.putExtra("cedula", regis.cedula);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "La persona no está registrada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regis = new registroPersona(ce.getText().toString(), nom.getText().toString(),
                        est.getItemAtPosition(est.getFirstVisiblePosition()).toString(),
                        sal.getText().toString(),
                        lvl.getItemAtPosition(lvl.getFirstVisiblePosition()).toString());
                if(c.buscarPersona(regis.cedula)){
                    long id = c.actualizarPersona(regis);
                    Toast.makeText(getApplicationContext(), "Datos de la persona actualizados", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "La persona no está registrada", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
