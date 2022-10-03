package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(this, R.raw.musictest);
    }

    public void  musicPlay(View view){
        music.start();
    }

    public void  musicPause(View view){
        music.pause();
    }

    public void  musicStop(View view){
        music.stop();
        music = MediaPlayer.create(this,R.raw.musictest);
    }

}