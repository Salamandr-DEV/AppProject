package com.example.appproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class choice extends AppCompatActivity {
    
        //  Button yesNo;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.choice);

            Button yesNo = (Button)findViewById(R.id.yesNo);
            // yesNo.setOnClickListener(this);

            // создаем обработчик нажатия
            View.OnClickListener oclyesNo = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i = new Intent(choice.this, yes_no.class);
                    startActivity(i);
                }
            };

            // присвоим обработчик кнопке OK (btnOk)
            yesNo.setOnClickListener(oclyesNo);
        }


        // @Override
   /* public void clickYesNo(View view) {
        Intent i;
        i = new Intent(this, yes_no.class);
        startActivity(i);
    }*/


    }