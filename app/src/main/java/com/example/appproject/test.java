package com.example.appproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class test extends AppCompatActivity{
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_test);

        CardView yesnocard = (CardView) findViewById(R.id.yes_no_card);
        CardView numbercard = (CardView) findViewById(R.id.number_card);
        CardView randomcard = (CardView) findViewById(R.id.random_card);
        CardView helpcard = (CardView) findViewById(R.id.help_card);

        yesnocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYesNo2();
            }
        });
        numbercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenNumber();
            }
        });
        randomcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSeveralchoise();
            }
        });
        helpcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYesNo2();
            }
        });
    }
    public void openYesNo2() {
        Intent i;
        i = new Intent(this, yes_no.class);
        startActivity(i);
    }

    public void OpenNumber() {
        Intent i;
        i = new Intent(this, Number.class);
        startActivity(i);
    }

    public void OpenSeveralchoise() {
        Intent i;
        i = new Intent(this, severalchoise.class);
        startActivity(i);
    }
}