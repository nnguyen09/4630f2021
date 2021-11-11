package com.example.a3_secondphaseofapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnAboutMe, btnInvestPortfolio, btnResume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiViews();
        buttonOnClick();
    }

    public void buttonOnClick(){
        btnAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,AboutMe.class );
                startActivity(intent1);
            }
        });

        btnInvestPortfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, InvestmentPortfolio.class);
                startActivity(intent2);
            }
        });

        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Resume.class);
                startActivity(intent3);
            }
        });

    }

    private void intiViews(){
        btnAboutMe = findViewById(R.id.btnAboutMe);
        btnInvestPortfolio = findViewById(R.id.btnInvestPortfolio);
        btnResume = findViewById(R.id.btnResume);
    }

}