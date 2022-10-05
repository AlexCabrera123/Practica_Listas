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
    private Button bGuardar;
    private ListView lvlista;
    private ArrayList alnumeros;
    private NodoLista primero = null;
    private TextView promedio, cantidadsueldos, sumasueldos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaEnlazada le = new ListaEnlazada();
        le.crearListaEnlazada();
        etAgregar = findViewById(R.id.etAgregar);
        bGuardar = findViewById(R.id.bGuardar);
        sumasueldos = findViewById(R.id.SumaSueldos);
        cantidadsueldos = findViewById(R.id.CantidadSueldos);
        promedio = findViewById(R.id.Promedio);
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
                    resultado += null+" -> ";
                    auxPri = auxPri.getEnlace();
                    alnumeros.add(auxPri.getDato());
                }
                Log.i("Log",resultado);

                lvlista.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
