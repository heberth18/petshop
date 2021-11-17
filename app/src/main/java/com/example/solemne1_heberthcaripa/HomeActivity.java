package com.example.solemne1_heberthcaripa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;


public class HomeActivity extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vw);

        String ruta = "android.resource://"+ getPackageName() + "/" + R.raw.video_pet_shop;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        video.start();

    }

    public void navegarAccesorios(View view) {
        Intent i = new Intent(this, InsumosActivity.class);
        startActivity(i);

    }

    public void navegarInfo(View view) {
        Intent i = new Intent(this, InforActivity.class);
        startActivity(i);

    }



}

