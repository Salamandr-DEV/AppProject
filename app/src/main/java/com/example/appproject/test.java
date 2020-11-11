package com.example.appproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.Locale;

public class test extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//            String languageToLoad  = "en"; // your language
//            Locale locale = new Locale(languageToLoad);
//            Locale.setDefault(locale);
//            Configuration config = new Configuration();
//            config.locale = locale;
//            getBaseContext().getResources().updateConfiguration(config,
//                    getBaseContext().getResources().getDisplayMetrics());
//            this.setContentView(R.layout.activity_test);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_test);

        CardView yesnocard = (CardView) findViewById(R.id.yes_no_card);
        CardView numbercard = (CardView) findViewById(R.id.number_card);
        CardView randomcard = (CardView) findViewById(R.id.random_card);
        CardView helpcard = (CardView) findViewById(R.id.help_card);

        Button langbutton = (Button)  findViewById(R.id.lang_button);

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
                openFullscreenActivity();
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
        i = new Intent(this, test_random.class);
        startActivity(i);
    }

    public void openFullscreenActivity() {

    }







}