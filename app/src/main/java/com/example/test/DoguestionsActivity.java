package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class DoguestionsActivity extends AppCompatActivity {
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doguestions);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mainGrid = findViewById(R.id.mainGrid);
        setToggleEvent(mainGrid);
        CardView PLUS = findViewById(R.id.tutorialplus);
        CardView MIN = findViewById(R.id.tutorialmin);
        CardView DEL = findViewById(R.id.tutorialdel);
        CardView UMN = findViewById(R.id.tutorialumn);
        CardView mix = findViewById(R.id.tutorialmix);
        Button button_back = findViewById(R.id.button_back);
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
        PLUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, Doguestion2.class));
            }
        });
        MIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, Doguestion2.class));
            }
        });
        DEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, Doguestion2.class));
            }
        });
        UMN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, Doguestion2.class));
            }
        });
        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoguestionsActivity.this, Doguestion2.class));
            }
        });
    }
    private void setToggleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int idx = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (idx <= 3) {
                        gotoOperation(idx);
                    }
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        Toast.makeText(DoguestionsActivity.this, "State: True", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DoguestionsActivity.this, "State: False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void gotoOperation(int operation) {
        Intent intentOperation = new Intent(this, Doguestion2.class);
        Bundle b = new Bundle();
        b.putInt("operation", operation);
        intentOperation.putExtras(b);
        startActivity(intentOperation);
    }
}
