package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Number extends AppCompatActivity {

    TextView text_v;
    Button button_v;
    EditText number_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_number);

        text_v      = findViewById(R.id.textView);
        button_v    = findViewById(R.id.randombtn);
        number_edit      = findViewById(R.id.editTextNumber);

        button_v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Random rand = new Random();
                if(!number_edit.getText().toString().equals("")) {
                    int random_number = Integer.parseInt(number_edit.getText().toString());
                    int number = rand.nextInt(random_number) + 1;
                    text_v.setText(String.valueOf(number));
                }
                else{
                    int number = rand.nextInt(100) + 1;
                    text_v.setText(String.valueOf(number));
                }
            }
        });
    }
}