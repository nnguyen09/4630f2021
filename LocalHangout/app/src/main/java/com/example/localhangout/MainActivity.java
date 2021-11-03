package com.example.localhangout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgView;
    private Drawable drawable;
    private Button btnSignup;
    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.imgFrontPage);
        drawable = getResources().getDrawable(R.drawable.boston);
        imgView.setImageDrawable(drawable);

        initViews();
        btnSignupOnClick();
        txtLoginOnClick();

    }

    public void txtLoginOnClick(){
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainActivity.this, Login.class);
                startActivity(login);
            }
        });
    }

    public void btnSignupOnClick(){
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUp);
            }
        });
    }

    private void initViews(){
        btnSignup = findViewById(R.id.btnSignUp);
        txtLogin = findViewById(R.id.txtLogin);
    }
}