package com.example.practica_listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button bMostrar;
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
        bMostrar = findViewById(R.id.bMostrar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = Integer.parseInt(etAgregar.getText().toString().trim());
                primero =  new NodoLista(aux,primero);
                etAgregar.setText("");
            }
        });

        bMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = "";
                NodoLista auxPri = primero;
                while(auxPri != null){
                    resultado += auxPri+ " -> ";
                    auxPri = auxPri.getEnlace();
                }
                Log.i("log",resultado);
            }
        });


        Log.i("log",le.toString());
    }
}