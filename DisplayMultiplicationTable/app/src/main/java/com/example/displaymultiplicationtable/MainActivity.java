package com.example.displaymultiplicationtable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView result;
    int ans = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.textView);

        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button:
                        StringBuffer buffer = new StringBuffer();
                        int res;
                        String fs = editText.getText().toString();
                        int n = Integer.parseInt(fs);
                        for (int i = 1 ; i <= 10; i++){
                            ans = (i * n);
                            buffer.append(n + "X" + i+ "=" + ans+ "\n\n");
                        }

                        result.setText(buffer);
                        break;
                }
            }
        }));
    }



}