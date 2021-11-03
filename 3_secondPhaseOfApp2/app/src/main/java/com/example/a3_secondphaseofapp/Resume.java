package com.example.a3_secondphaseofapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Resume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        PDFView pdfView = findViewById(R.id.pdfResume);
        pdfView.fromAsset("N_Nguyen_UML.pdf").load();
    }
}