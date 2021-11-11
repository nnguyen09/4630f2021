package com.example.localhangout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText eName, ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;

    private String Username = "Admin";
    private String Password = "12345678";

    boolean isValid = false;
    private int counter = 5;

    private TextView userRegistration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);
        userRegistration = findViewById(R.id.tvRegister);


        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty()||inputPassword.isEmpty()){
                    Toast.makeText(Login.this, "Please enter all the detail correctly", Toast.LENGTH_SHORT).show();
                }else{
                    isValid = validate(inputName, inputPassword);
                    if(!isValid){
                        counter --;
                        Toast.makeText(Login.this, "Incorrect credentials entered ", Toast.LENGTH_SHORT).show();

                        eAttemptsInfo.setText("No. of attempts remaining: "+ counter);

                        if(counter == 0){
                            eLogin.setEnabled(false); // disable login button after certain attempt
                        }
                    }else {
                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();

                        //Create new activity when login successful
                        Intent intent = new Intent(Login.this, FindYourGroup.class);
                        startActivity(intent);
                    }

                }
                Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
            }

        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });
    }

    private boolean validate (String name, String password){
        if((name.equals(Username))&&(password.equals(Password))){
            return true;
        }
        return false;
    }


}