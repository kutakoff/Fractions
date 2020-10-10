package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridLayout mainGrid;
    CardView reports;
    CardView doguestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reports = findViewById(R.id.reports);
        doguestions = findViewById(R.id.doguestions);
        mainGrid = findViewById(R.id.mainGrid);
        setToggleEvent(mainGrid);
        doguestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DoguestionsActivity.class));
            }
        });
        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TutorialActivity.class));
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
                    }
                }
            });
        }
    }

    private void gotoOperation(int operation) {
        Intent intentOperation = new Intent(this, OperationActivity.class);
        Bundle b = new Bundle();
        b.putInt("operation", operation);
        intentOperation.putExtras(b);
        startActivity(intentOperation);
    }
}