package com.example.appproject;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;

public class test_random extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerlayout;
    String[] mainarray;

    int OldValue;
    TextView text_several;
    Button button_several;
    ImageButton button_back_to_menu;
    Button button_go_option;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_test_random);

        button_back_to_menu    = findViewById(R.id.back_menu);
        button_back_to_menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                backToMenu();
            }
        });

        button_go_option   = findViewById(R.id.button_option);
        button_go_option.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                goToOption();
            }
        });
        
        Toolbar toolbar_ = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar_);

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerlayout = (DrawerLayout)findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar_, R.string.Open, R.string.Close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_home:
                        break;

                    case R.id.menu_option:
                        openOption();
                        break;

                    case R.id.menu_help:
                        break;
                }
                return true;
            }
        });

        changeTextView();

        Bundle b = this.getIntent().getExtras();
        if(b != null) {
            mainarray = b.getStringArray("array");
        }
    }
    private void changeTextView(){
        text_several      = findViewById(R.id.text_several);
        button_several    = findViewById(R.id.button_several);
        button_several.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(mainarray != null)
                {
                    int random = (int) (Math.random() * mainarray.length);
                    if (random == OldValue) {
                        random = (int) (Math.random() * mainarray.length);
                    }
                    text_several.setText(mainarray[random]);
                    OldValue = random;
                }
            }
        });
    }
    public void backToMenu()
    {
        Intent i;
        i = new Intent(this, test.class);
        startActivity(i);
    }
    public void goToOption()
    {
        Intent i;
        i = new Intent(this, option.class);
        startActivity(i);
    }
    public void openOption() {
        Intent i;
        i = new Intent(this, option.class);
        startActivity(i);
    }
    public void openHome() {
        Intent i;
        i = new Intent(this, test_random.class);
        startActivity(i);
    }
}