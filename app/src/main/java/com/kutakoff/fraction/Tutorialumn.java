package com.kutakoff.fraction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.kutakoff.fraction.R;

public class Tutorialumn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_tutorialumn);
        VideoView videoView = findViewById(R.id.video_view4);
        Button button_back = findViewById(R.id.button_back);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.umn;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Tutorialumn.this, TutorialActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception ignored) {

                }
            }
        });
    }
}