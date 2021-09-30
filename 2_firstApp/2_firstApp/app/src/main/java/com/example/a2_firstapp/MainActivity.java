package com.example.a2_firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        ImageView img = findViewById(R.id.backGroundImage);
        TextView name = findViewById(R.id.studentName);
        name.setText("Hello World");
        img.setImageResource(R.drawable.profile);

    }
}