package com.example.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int result;
    static  int getRandomNumber(int max, int min){
        return (int)(Math.random()* (max - min) + min);
    }
    public void makeToast(String str){
        Toast.makeText(MainActivity.this, str,Toast.LENGTH_LONG).show();
    }

    public void clickFunction(View view){
        int userGuessing;
        EditText editText = findViewById(R.id.editId);
        TextView answer = findViewById(R.id.answer);
        userGuessing = Integer.parseInt(editText.getText().toString());

        if (userGuessing < result){
            makeToast("Think higher number, try again!!");
        } else if (userGuessing > result){
            makeToast("Think lower number, try again!");
        }else {
            answer.setText("Bingo you got the Number!!");
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int min = 1;
        int max = 100;
        result = getRandomNumber(max,min);

    }
}