package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    EditText number_edit2;
    Button  buttonHelp;
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
        number_edit2      = findViewById(R.id.editTextNumber2);
        buttonHelp = findViewById(R.id.btnHelpNumber);

        button_v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Random rand = new Random();
                if(!number_edit.getText().toString().equals("")) {
                    int random_number = Integer.parseInt(number_edit.getText().toString());
                    int random_number2 = Integer.parseInt(number_edit2.getText().toString());
                    int number = 0;
                    if(random_number > random_number2)
                    {
                        number = rand.nextInt(random_number - random_number2) + random_number2 +1;
                    }
                    if(random_number2 > random_number)
                    {
                        number = rand.nextInt(random_number2 - random_number) + random_number + 1;
                    }
                    text_v.setText(String.valueOf(number));
                }
                else{
                    int number = rand.nextInt(100) + 1;
                    text_v.setText(String.valueOf(number));
                }
            }
        });

        buttonHelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(Number.this);
                builder.setTitle(R.string.helpTitle)
                        .setMessage(R.string.helpTextNumber)

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