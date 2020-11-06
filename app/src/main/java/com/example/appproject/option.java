package com.example.appproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class option extends AppCompatActivity {
    //Создаем список вьюх которые будут создаваться
    private List<View> allEds;
    //счетчик чисто декоративный для визуального отображения edittext'ov
    private int counter = 0;
    String [] items;

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerlayout;
    ImageButton button_back_to_decision;
    Button button_go_test_random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_option);

        button_back_to_decision   = findViewById(R.id.back_decision);
        button_back_to_decision.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                backToDecision();
            }
        });

        button_go_test_random   = findViewById(R.id.button_test_random);
        button_go_test_random.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                goToDecision();
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
                        openHome();
                        break;

                    case R.id.menu_option:
                        break;

                    case R.id.menu_help:
                        break;
                }
                return true;
            }
        });

        Button addButton = (Button) findViewById(R.id.button);
        //инициализировали наш массив с edittext.aьи
        allEds = new ArrayList<View>();

        //находим наш linear который у нас под кнопкой add edittext в activity_main.xml
        final LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        addButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                counter++;

                //берем наш кастомный лейаут находим через него все наши кнопки и едит тексты, задаем нужные данные
                @SuppressLint("InflateParams") final View view = getLayoutInflater().inflate(R.layout.custom_button, null);
                Button deleteField = (Button) view.findViewById(R.id.button2);
                deleteField.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            ((LinearLayout) view.getParent()).removeView(view);
                            allEds.remove(view);
                        } catch(IndexOutOfBoundsException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                EditText text = (EditText) view.findViewById(R.id.editText);
                text.setText("Option " + counter);
                //добавляем все что создаем в массив
                allEds.add(view);
                //добавляем елементы в linearlayout
                linear.addView(view);
            }
        });
    }
    public void backToDecision()
    {
        Intent i;
        OnWrite();
        Bundle b = new Bundle();
        b.putStringArray("array", items);
        i = new Intent(this, test_random.class);
        i.putExtras(b);
        startActivity(i);
    }
    public void goToDecision()
    {
        Intent i;
        OnWrite();
        Bundle b = new Bundle();
        b.putStringArray("array", items);
        i = new Intent(this, test_random.class);
        i.putExtras(b);
        startActivity(i);
    }
    public void openOption() {
        Intent i;
        i = new Intent(this, option.class);
        startActivity(i);
    }
    public void openHome() {
        Intent i;
        OnWrite();
        Bundle b = new Bundle();
        b.putStringArray("array", items);
        i = new Intent(this, test_random.class);
        i.putExtras(b);
        startActivity(i);
    }
    public void OnWrite()
    {
        items = new String[allEds.size()];
        for(int i=0; i < allEds.size(); i++) {
            items[i] = ((EditText) allEds.get(i).findViewById(R.id.editText)).getText().toString();
        }
    }
}