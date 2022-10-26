package com.example.binary2decimal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText input, output;
        Button submit, reset;

        input = findViewById(R.id.editText);
        output =findViewById(R.id.output);
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = input.getText().toString();

                int i = Integer.parseInt(string,2);

                String decimal = Integer.toString(i);

                output.setText(decimal);

            }


        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
                output.setText("");
            }
        });


    }
}