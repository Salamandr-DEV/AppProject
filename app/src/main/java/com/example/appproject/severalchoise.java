package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class severalchoise extends AppCompatActivity {

    int OldValue;
    TextView text_several;
    Button button_several;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_severalchoise);

        changeTextView();
    }

    private void changeTextView(){
        final String[] manystring = {"Вариант 1", "Вариант 2", "Вариант 3", "Ишь че удумал, хочешь что бы программа за тебя принимала решения."};

        text_several      = findViewById(R.id.text_several);
        button_several    = findViewById(R.id.button_several);
        button_several.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                int random = (int) (Math.random() * manystring.length);
                if (random == OldValue) {
                    random = (int) (Math.random() * manystring.length);
                }
                text_several.setText(manystring[random]);
                OldValue = random;
            }
        });
    }
}