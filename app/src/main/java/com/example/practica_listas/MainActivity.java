package com.example.practica_listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etAgregar;
    private Button bGuardar;
    private NodoLista primero = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListaEnlazada le = new ListaEnlazada();
        le.crearListaEnlazada();
        etAgregar = findViewById(R.id.etAgregar);
        bGuardar = findViewById(R.id.bGuardar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = Integer.parseInt(etAgregar.getText().toString().trim());
                new NodoLista(aux,primero);
            }
        });


        Log.i("log",le.toString());
    }
}