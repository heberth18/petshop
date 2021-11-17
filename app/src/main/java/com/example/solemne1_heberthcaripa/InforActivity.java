package com.example.solemne1_heberthcaripa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class InforActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
    }


    public void marcar(View view){
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:958939817"));
        startActivity(i);
    }

    public void maps(View view){
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }

}