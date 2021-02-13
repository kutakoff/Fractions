package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

public class TutorialActivity extends AppCompatActivity {
CardView tutorialplus;
CardView tutorialmin;
CardView tutorialumn;
CardView tutorialdel;
CardView firststartvideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_tutorial);

        Button button_back = findViewById(R.id.button_back);
        tutorialplus = findViewById(R.id.tutorialplus);
        tutorialmin = findViewById(R.id.tutorialmin);
        tutorialumn = findViewById(R.id.tutorialumn);
        tutorialdel = findViewById(R.id.tutorialdel);
        firststartvideo = findViewById(R.id.firststartvideo);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        MediaController mediaController = new MediaController(this);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(TutorialActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        tutorialplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TutorialActivity.this, Tutorialplus.class));
            }
        });
        tutorialmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TutorialActivity.this, Tutorialminus.class));
            }
        });
        tutorialumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TutorialActivity.this, Tutorialumn.class));
            }
        });
        tutorialdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TutorialActivity.this, Tutorialdel.class));
            }
        });
        firststartvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TutorialActivity.this, Startvideo.class));
            }
        });
    }
}