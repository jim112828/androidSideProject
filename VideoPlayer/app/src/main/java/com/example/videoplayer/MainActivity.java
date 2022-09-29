package com.example.videoplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    VideoView vw;
    ArrayList<Integer> videolist = new ArrayList<>();
    int currvideo = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vw =findViewById(R.id.videoView);
        vw.setMediaController(new MediaController(this));
        vw.setOnCompletionListener(this::onCompletion);

        videolist.add(R.raw.middle);
        videolist.add(R.raw.faded);
        videolist.add(R.raw.aeroplane);
        setVideo(videolist.get(0));
    }
    public void setVideo(int id){
        String uriPath = "android.resource://" + getPackageName() + "/" + id;
        Uri uri = Uri.parse(uriPath);
        vw.setVideoURI(uri);
        vw.start();
    }

    public void onCompletion(MediaPlayer mediaPlayer){
        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setTitle("Playback Finished!");
        obj.setIcon(R.mipmap.ic_launcher);
        MyListener m = new MyListener();
        obj.setPositiveButton("Replay",m);
        obj.setNegativeButton("Next",m);
        obj.setMessage("Want to replay or play next Video?");
        obj.show();
    }

    class MyListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == -1){
                vw.seekTo(0);
                vw.start();
            }else {
                ++currvideo;
                if (currvideo == videolist.size()){
                    currvideo = 0;
                }
                setVideo(videolist.get(currvideo));
            }
        }
    }


}