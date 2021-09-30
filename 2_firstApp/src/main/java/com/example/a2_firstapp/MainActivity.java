package com.example.a2_firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //clickButton();
    }

    public void clickButton(View view){
        TextView name = findViewById(R.id.studentName);
        ImageView img = findViewById(R.id.backGroundImage);
        name.setText(null);
        img.setImageResource(R.drawable.profile);
    }
}  @Override