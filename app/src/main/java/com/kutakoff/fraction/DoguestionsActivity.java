package com.kutakoff.fraction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class DoguestionsActivity extends AppCompatActivity {
    GridLayout mainGrid;
    CardView re_plus;
    CardView re_min;
    CardView re_umn;
    CardView re_del;
    CardView re_mix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doguestions);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mainGrid = findViewById(R.id.mainGrid);
        re_plus = findViewById(R.id.re_plus);
        re_min = findViewById(R.id.re_min);
        re_umn = findViewById(R.id.re_umn);
        re_del = findViewById(R.id.re_del);
        re_mix = findViewById(R.id.re_mix);
        Button button_back = findViewById(R.id.button_back);
        re_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, GuestionActivity.class));
            }
        });
        re_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, GuestionActivity.class));
            }
        });
        re_umn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, GuestionActivity.class));
            }
        });
        re_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, GuestionActivity.class));
            }
        });
        re_mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, GuestionActivity.class));
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(DoguestionsActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
    }
}
