package com.unydevelopernetwork.simplevideostreamer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.material.snackbar.Snackbar;

public class VideoPlayer extends AppCompatActivity {

    private VideoView videoPlayer;
    private String videoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        initLevel0();
        initLevel1();
        initLevel2();
    }

    private void initLevel0(){
        videoPlayer = findViewById(R.id.video_player);
    }

    private void initLevel1(){
        videoURL = getIntent().getStringExtra("VIDEO_URL");
    }

    private void initLevel2(){
        videoPlayer();
    }

    private void videoPlayer(){
        Snackbar.make(findViewById(android.R.id.content), "Video Buffering...", Snackbar.LENGTH_LONG).show();
        try {
            getWindow().setFormat(PixelFormat.TRANSLUCENT);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoPlayer);

            Uri video = Uri.parse(videoURL);
            videoPlayer.setMediaController(mediaController);
            videoPlayer.setVideoURI(video);
            videoPlayer.requestFocus();
            videoPlayer.setOnPreparedListener(mp -> videoPlayer.start());
        }
        catch(Exception e) {
            Snackbar.make(findViewById(android.R.id.content), "Video Play Error:" + e, Snackbar.LENGTH_LONG).show();
            finish();
        }
    }
}