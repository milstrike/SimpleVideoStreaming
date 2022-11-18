package com.unydevelopernetwork.simplevideostreamer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputURL;
    private Button btnStartStream, btnReset;
    private String videoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLevel0();
        initLevel1();
        initLevel2();
    }

    private void initLevel0(){
        inputURL = findViewById(R.id.input_url);
        btnStartStream = findViewById(R.id.start_button);
        btnReset = findViewById(R.id.reset_button);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initLevel1(){
        btnStartStream.setOnTouchListener((view, motionEvent) -> {
            getInput();
            startStream();
            return false;
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initLevel2(){
        btnReset.setOnTouchListener((view, motionEvent) -> {
            resetInput();
            return false;
        });
    }

    private void getInput(){
        videoURL = inputURL.getText()+"";
    }

    private void startStream(){
        Intent streamIntent = new Intent(MainActivity.this, VideoPlayer.class);
        streamIntent.putExtra("VIDEO_URL", videoURL);
        startActivity(streamIntent);
    }

    private void resetInput(){
        inputURL.getText().clear();
    }
}