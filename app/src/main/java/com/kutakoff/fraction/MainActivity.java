package com.kutakoff.fraction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import com.kutakoff.fraction.OperationActivity;
import com.kutakoff.fraction.TutorialActivity;

public class MainActivity extends AppCompatActivity {
    GridLayout mainGrid;
    CardView learn;
    CardView doguestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        learn = findViewById(R.id.learn);
        doguestions = findViewById(R.id.tutorialumn);
        mainGrid = findViewById(R.id.mainGrid);
        setToggleEvent(mainGrid);
        learn.setOnClickListener(new View.OnClickListener() {
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