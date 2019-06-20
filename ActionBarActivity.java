package com.example.mediaplayer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.VideoView;

public class ActionBarActivity extends Activity {
    VideoView video;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reult);
        if(getIntent().getStringExtra("from").equals("intent1")){
            video=(VideoView)findViewById(R.id.View1);
            video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video1);
            video.start();
        }else if(getIntent().getStringExtra("from").equals("intent2")){
            video=(VideoView)findViewById(R.id.View2);
            video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video2);
            video.start();
        }else if(getIntent().getStringExtra("from").equals("intent3")){
            video=(VideoView)findViewById(R.id.View3);
            video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video3);
            video.start();
        }else{
            video=(VideoView)findViewById(R.id.View4);
            video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video4);
            video.start();
        }
    }
}


