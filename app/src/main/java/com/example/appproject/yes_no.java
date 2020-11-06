package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class yes_no extends AppCompatActivity {

    TextView textYesNo;
    Button buttonYesNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.yes_no);

        textYesNo      = findViewById(R.id.textYesNo);
        buttonYesNo    = findViewById(R.id.buttonYesNo);

        buttonYesNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Random rand = new Random();
                int number = rand.nextInt(2);
                if(number == 0)
                {
                    textYesNo.setText("No");
                }
                if(number == 1)
                {
                    textYesNo.setText("Yes");
                }

            }
        });
    }
}
