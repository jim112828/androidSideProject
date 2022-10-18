package com.example.simplemagic8ball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.image_eightBall);
        Button button = findViewById(R.id.askButton);
        final int a[] = {R.drawable.ball2,R.drawable.ball3,R.drawable.ball4,R.drawable.ball5};

        button.setOnClickListener(view -> {
            Random random = new Random();
            int x = random.nextInt(4);

            imageView.setImageResource(a[x]);
        });



    }
}