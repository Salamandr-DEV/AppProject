package com.example.appproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class yes_no extends AppCompatActivity {

    TextView textYesNo;
    Button buttonYesNo;
    ImageButton buttonHelp;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.yes_no);

        textYesNo      = findViewById(R.id.textYesNo);
        buttonYesNo    = findViewById(R.id.buttonYesNo);
        buttonHelp = findViewById(R.id.btnHelpYesNo);

        buttonYesNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Random rand = new Random();
                int number = rand.nextInt(2);
                if(number == 0)
                {
                    textYesNo.setText(R.string.yes);
                }
                if(number == 1)
                {
                    textYesNo.setText(R.string.no);
                }


            }
        });
        buttonHelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(yes_no.this);
                builder.setTitle(R.string.helpTitle)
                        .setMessage(R.string.helpTextYesNo)

                        .setCancelable(false)
                        .setNegativeButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }





    }

