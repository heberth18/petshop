package com.example.solemne1_heberthcaripa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Accesorios;

public class InsumosActivity extends AppCompatActivity {

    private Spinner accesorios;
    private RatingBar calificacion;
    private TextView texto1, texto2, resultado1;
    private int adicional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        accesorios = (Spinner)findViewById(R.id.spnAccesorios);
        calificacion = (RatingBar)findViewById(R.id.rt);
        texto1 = (TextView)findViewById(R.id.tv1);
        texto2 = (TextView)findViewById(R.id.tv2);
        resultado1 = (TextView)findViewById(R.id.result1);


        Accesorios jar = new Accesorios();


        ArrayAdapter adaptMateriales = new ArrayAdapter(this, android.R.layout.simple_list_item_1,jar.getJarrones());

        accesorios.setAdapter(adaptMateriales);


        accesorios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Accesorios accesorios = new Accesorios();
                adicional = accesorios.getAdicional()[i];
                texto1.setText("El adicional es: "+ String.valueOf(adicional));
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


    }

    public void Calcular(View view) {
        int precio, valor;
        Accesorios accesorios = new Accesorios();
        if (this.accesorios.getSelectedItem().toString().equals("Collar")) {
            precio = accesorios.getPrecios()[0];
            adicional = accesorios.getAdicional()[0];
            calificacion.setRating(2);
        } else if (this.accesorios.getSelectedItem().toString().equals("Cepillo")) {
            precio = accesorios.getPrecios()[1];
            adicional = accesorios.getAdicional()[1];
            calificacion.setRating(3);
        } else {
            precio = accesorios.getPrecios()[2];
            adicional = accesorios.getAdicional()[2];
            calificacion.setRating(5);
        }

        valor = precio + adicional;

        resultado1.setText("El costo final es: "+ String.valueOf(valor));

    }
}