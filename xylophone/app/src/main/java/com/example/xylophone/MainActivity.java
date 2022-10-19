package com.example.xylophone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final  int sim_sound = 7;
    private final float lft_vol = 1.0f;
    private final float rgt_vol = 1.0f;
    private final int loop = 0;
    private final int prty = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    private SoundPool mSoundPool;
    private int mCSoundId1;
    private int mCSoundId2;
    private int mCSoundId3;
    private int mCSoundId4;
    private int mCSoundId5;
    private int mCSoundId6;
    private int mCSoundId7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSoundPool = new SoundPool(sim_sound, AudioManager.STREAM_MUSIC, 0);

        mCSoundId1 = mSoundPool.load(getApplicationContext(), R.raw.note1_c,1);
        mCSoundId2 = mSoundPool.load(getApplicationContext(), R.raw.note2_d,1);
        mCSoundId3 = mSoundPool.load(getApplicationContext(), R.raw.note3_e,1);
        mCSoundId4 = mSoundPool.load(getApplicationContext(), R.raw.note4_f,1);
        mCSoundId5 = mSoundPool.load(getApplicationContext(), R.raw.note5_g,1);
        mCSoundId6 = mSoundPool.load(getApplicationContext(), R.raw.note6_a,1);
        mCSoundId7 = mSoundPool.load(getApplicationContext(), R.raw.note7_b,1);

    }

    public void c(View v){
        mSoundPool.play(mCSoundId1,lft_vol,rgt_vol,prty,loop,NORMAL_PLAY_RATE);
    }

    public void d(View v){
        mSoundPool.play(mCSoundId2,lft_vol,rgt_vol,prty,loop,NORMAL_PLAY_RATE);
    }
    public void e(View v){
        mSoundPool.play(mCSoundId3,lft_vol,rgt_vol,prty,loop,NORMAL_PLAY_RATE);
    }
    public void f(View v){
        mSoundPool.play(mCSoundId4,lft_vol,rgt_vol,prty,loop,NORMAL_PLAY_RATE);
    }
    public void g (View v){
        mSoundPool.play(mCSoundId5,lft_vol,rgt_vol,prty,loop,NORMAL_PLAY_RATE);
    }
    public void a(View v){
        mSoundPool.play(mCSoundId6,lft_vol,rgt_vol,prty,loop,NORMAL_PLAY_RATE);
    }
    public void b(View v){
        mSoundPool.play(mCSoundId7,lft_vol,rgt_vol,prty,loop,NORMAL_PLAY_RATE);
    }
}