package com.example.practica_listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button bMostrar;
    private EditText etAgregar;
    private Button bGuardar, bBuscar;
    private ListView lvlista;
    private ArrayList alnumeros;
    private NodoLista primero = null;
    private Double suma,promedio;
    private int cantidad,cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAgregar = findViewById(R.id.etAgregar);
        bGuardar = findViewById(R.id.bGuardar);
        bMostrar = findViewById(R.id.bBuscar);
        lvlista = findViewById(R.id.lvlista);

        ArrayList<Double> alnumeros = new ArrayList<>();
        ArrayAdapter<Double> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,alnumeros);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = etAgregar.getText().toString().trim();
                if(input.equals(""))
                    Toast.makeText(getApplicationContext(),"FAVOR DE AGREGAR SUELDO",Toast.LENGTH_LONG).show();
                else {
                    double aux = Double.parseDouble(input);
                    primero = new NodoLista(aux,primero);
                }

                String resultado = "";
                NodoLista auxPri = primero;
                alnumeros.clear();
                while(auxPri != null){
                    cantidad++;
                    resultado += null+" -> ";
                    auxPri = auxPri.getEnlace();
                    alnumeros.add(auxPri.getDato());
                    suma += auxPri.getDato();
                    auxPri = auxPri.getEnlace();
                }
                Log.i("Log",resultado);

                Log.i("Log","Total de sueldos"+suma);
                Log.i("Log","Cantidad de sueldos"+cantidad);
                Log.i("Log","Promedio sueldos"+suma/cantidad);

                lvlista.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });

        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input2 = etAgregar.getText().toString().trim();
                if(input2.equals(""))
                    Toast.makeText(getApplicationContext(),"FAVOR DE AGREGAR EL NUMERO A BUSCAR",Toast.LENGTH_LONG).show();
                else {
                    double aux2 = Double.parseDouble(input2);
                    while(primero.getDato() == aux2){
                        cont++;
                        if (primero.getDato() == aux2){
                            Log.i("Log","El número está en la posición "+cont);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"NO SE ENCONTRÓ EL NÚMERO",Toast.LENGTH_LONG).show();
                        }
                        break;
                    }

                }



            }
        });
    }
}
