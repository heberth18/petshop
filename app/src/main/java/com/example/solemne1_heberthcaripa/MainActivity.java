package com.example.solemne1_heberthcaripa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Accesorios;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, password;
    private TextView msj;
    private ProgressBar barra;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText)findViewById((R.id.tvUsuario));
        password = (EditText)findViewById((R.id.tvContrasena));
        msj = (TextView)findViewById((R.id.msj)) ;
        barra = findViewById(R.id.pb);
        btn = findViewById(R.id.btnIngresar);
        Accesorios jar = new Accesorios();
        barra.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msj.setText("");
                if(usuario.getText().toString().equals("") || password.getText().toString().equals("") ){
                    msj.setText("Error debe ingresar usuario y password");
                } else if (usuario.getText().toString().equals("heberth") && password.getText().toString().equals("123")){
                    new Task().execute();
                } else {
                    msj.setText("Error usuario o password incorrecto");
                }
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500);
                }

            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            barra.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), HomeActivity.class);
            startActivity(i);
        }
    }

    public void Calcular(View view){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }



    }
