package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatDelegate;

import java.util.Random;

public class Doguestion2 extends Activity {

    ViewFlipper flipper;

    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_doguestion2);
        flipper = findViewById(R.id.viewflipper);
        TextView edNumerator1 = findViewById(R.id.edNumerator1);
        TextView edNumerator11 = findViewById(R.id.edNumerator11);
        TextView edNumerator12 = findViewById(R.id.edNumerator12);
        TextView edNumerator13 = findViewById(R.id.edNumerator13);
        TextView edNumerator14 = findViewById(R.id.edNumerator14);
        TextView edNumerator15 = findViewById(R.id.edNumerator15);
        TextView edNumerator16 = findViewById(R.id.edNumerator16);
        TextView edNumerator17 = findViewById(R.id.edNumerator17);
        TextView edNumerator18 = findViewById(R.id.edNumerator18);
        TextView edNumerator19 = findViewById(R.id.edNumerator19);
        TextView edNumerator2 = findViewById(R.id.edNumerator2);
        TextView edNumerator21 = findViewById(R.id.edNumerator21);
        TextView edNumerator22= findViewById(R.id.edNumerator22);
        TextView edNumerator23 = findViewById(R.id.edNumerator23);
        TextView edNumerator24= findViewById(R.id.edNumerator24);
        TextView edNumerator25 = findViewById(R.id.edNumerator25);
        TextView edNumerator26 = findViewById(R.id.edNumerator26);
        TextView edNumerator27 = findViewById(R.id.edNumerator27);
        TextView edNumerator28 = findViewById(R.id.edNumerator28);
        TextView edNumerator29 = findViewById(R.id.edNumerator29);
        TextView edDenominator1 = findViewById(R.id.edDenominator1);
        TextView edDenominator11 = findViewById(R.id.edDenominator11);
        TextView edDenominator12 = findViewById(R.id.edDenominator12);
        TextView edDenominator13 = findViewById(R.id.edDenominator13);
        TextView edDenominator14 = findViewById(R.id.edDenominator14);
        TextView edDenominator15 = findViewById(R.id.edDenominator15);
        TextView edDenominator16 = findViewById(R.id.edDenominator16);
        TextView edDenominator17 = findViewById(R.id.edDenominator17);
        TextView edDenominator18 = findViewById(R.id.edDenominator18);
        TextView edDenominator19 = findViewById(R.id.edDenominator19);
        TextView edDenominator2 = findViewById(R.id.edDenominator2);
        TextView edDenominator21= findViewById(R.id.edDenominator21);
        TextView edDenominator22 = findViewById(R.id.edDenominator22);
        TextView edDenominator23 = findViewById(R.id.edDenominator23);
        TextView edDenominator24 = findViewById(R.id.edDenominator24);
        TextView edDenominator25 = findViewById(R.id.edDenominator25);
        TextView edDenominator26 = findViewById(R.id.edDenominator26);
        TextView edDenominator27 = findViewById(R.id.edDenominator27);
        TextView edDenominator28 = findViewById(R.id.edDenominator28);
        TextView edDenominator29= findViewById(R.id.edDenominator29);

        Button button_back = findViewById(R.id.button_back);
        Button button_back1 = findViewById(R.id.button_back1);
        Button button_back2 = findViewById(R.id.button_back2);
        Button button_back3 = findViewById(R.id.button_back3);
        Button button_back4 = findViewById(R.id.button_back4);
        Button button_back5 = findViewById(R.id.button_back5);
        Button button_back6 = findViewById(R.id.button_back6);
        Button button_back7 = findViewById(R.id.button_back7);
        Button button_back8 = findViewById(R.id.button_back8);
        Button button_back9 = findViewById(R.id.button_back9);
        Random random = new Random();
        edNumerator1.setText(String.valueOf(random.nextInt(15)));
        edNumerator11.setText(String.valueOf(random.nextInt(15)));
        edNumerator12.setText(String.valueOf(random.nextInt(15)));
        edNumerator13.setText(String.valueOf(random.nextInt(15)));
        edNumerator14.setText(String.valueOf(random.nextInt(15)));
        edNumerator15.setText(String.valueOf(random.nextInt(15)));
        edNumerator16.setText(String.valueOf(random.nextInt(15)));
        edNumerator17.setText(String.valueOf(random.nextInt(15)));
        edNumerator18.setText(String.valueOf(random.nextInt(15)));
        edNumerator19.setText(String.valueOf(random.nextInt(15)));
        edDenominator1.setText(String.valueOf(random.nextInt(15)));
        edDenominator11.setText(String.valueOf(random.nextInt(15)));
        edDenominator12.setText(String.valueOf(random.nextInt(15)));
        edDenominator13.setText(String.valueOf(random.nextInt(15)));
        edDenominator14.setText(String.valueOf(random.nextInt(15)));
        edDenominator15.setText(String.valueOf(random.nextInt(15)));
        edDenominator16.setText(String.valueOf(random.nextInt(15)));
        edDenominator17.setText(String.valueOf(random.nextInt(15)));
        edDenominator18.setText(String.valueOf(random.nextInt(15)));
        edDenominator19.setText(String.valueOf(random.nextInt(15)));
        edDenominator2.setText(String.valueOf(random.nextInt(15)));
        edDenominator21.setText(String.valueOf(random.nextInt(15)));
        edDenominator22.setText(String.valueOf(random.nextInt(15)));
        edDenominator23.setText(String.valueOf(random.nextInt(15)));
        edDenominator24.setText(String.valueOf(random.nextInt(15)));
        edDenominator25.setText(String.valueOf(random.nextInt(15)));
        edDenominator26.setText(String.valueOf(random.nextInt(15)));
        edDenominator27.setText(String.valueOf(random.nextInt(15)));
        edDenominator28.setText(String.valueOf(random.nextInt(15)));
        edDenominator29.setText(String.valueOf(random.nextInt(15)));
        edNumerator2.setText(String.valueOf(random.nextInt(15)));
        edNumerator21.setText(String.valueOf(random.nextInt(15)));
        edNumerator22.setText(String.valueOf(random.nextInt(15)));
        edNumerator23.setText(String.valueOf(random.nextInt(15)));
        edNumerator24.setText(String.valueOf(random.nextInt(15)));
        edNumerator25.setText(String.valueOf(random.nextInt(15)));
        edNumerator26.setText(String.valueOf(random.nextInt(15)));
        edNumerator27.setText(String.valueOf(random.nextInt(15)));
        edNumerator28.setText(String.valueOf(random.nextInt(15)));
        edNumerator29.setText(String.valueOf(random.nextInt(15)));

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        button_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        button_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        button_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        button_back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        button_back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        button_back6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        button_back7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        button_back8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        button_back9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Doguestion2.this, DoguestionsActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        animFlipInForward = AnimationUtils.loadAnimation(this, R.anim.flipin);
        animFlipOutForward = AnimationUtils.loadAnimation(this, R.anim.flipout);
        animFlipInBackward = AnimationUtils.loadAnimation(this, R.anim.flipin_reverse);
        animFlipOutBackward = AnimationUtils.loadAnimation(this, R.anim.flipout_reverse);
    }

    private void SwipeLeft() {
        flipper.setInAnimation(animFlipInBackward);
        flipper.setOutAnimation(animFlipOutBackward);
        flipper.showPrevious();
    }

    private void SwipeRight() {
        flipper.setInAnimation(animFlipInForward);
        flipper.setOutAnimation(animFlipOutForward);
        flipper.showNext();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {

            float sensitvity = 50;
            if ((e1.getX() - e2.getX()) > sensitvity) {
                SwipeRight();
            } else if ((e2.getX() - e1.getX()) > sensitvity) {
                SwipeLeft();
            }
            return true;
        }
    };
    GestureDetector gestureDetector = new GestureDetector(getBaseContext(),
            simpleOnGestureListener);
}