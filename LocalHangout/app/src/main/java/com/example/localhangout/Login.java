package com.example.localhangout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText eName, ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;

    private String Username = "Admin";
    private String Password = "12345678";

    boolean isValid = false;
    private int counter = 5;

    private TextView userRegistration;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);
        userRegistration = findViewById(R.id.tvRegister);

        firebaseAuth = FirebaseAuth.getInstance();

        //check with the database if the user already login in the app or not
        FirebaseUser user = firebaseAuth.getCurrentUser();
        progressDialog = new ProgressDialog(this);

        if(user != null){
            finish();
            startActivity(new Intent(Login.this, FindYourGroup.class));
        }

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String inputName = eName.getText().toString();
//                String inputPassword = ePassword.getText().toString();
//
//                if(inputName.isEmpty()||inputPassword.isEmpty()){
//                    Toast.makeText(Login.this, "Please enter all the detail correctly", Toast.LENGTH_SHORT).show();
//                }else{
//                    isValid = validate(inputName, inputPassword);
//                    if(!isValid){
//                        counter --;
//                        Toast.makeText(Login.this, "Incorrect credentials entered ", Toast.LENGTH_SHORT).show();
//
//                        eAttemptsInfo.setText("No. of attempts remaining: "+ counter);
//
//                        if(counter == 0){
//                            eLogin.setEnabled(false); // disable login button after certain attempt
//                        }
//                    }else {
//                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
//
//                        //Create new activity when login successful
//                        Intent intent = new Intent(Login.this, FindYourGroup.class);
//                        startActivity(intent);
//                    }
//
//                }
//                Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();

                validate(eName.getText().toString(),ePassword.getText().toString());
            }

        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    private void validate (String name, String password){

        progressDialog.setMessage("you can subscribe to my chanel until you are verified");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(name, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, FindYourGroup.class));
                }else{
                    Toast.makeText(Login.this, "Login Fail", Toast.LENGTH_SHORT).show();
                    counter --;
                    eAttemptsInfo.setText("No. of attempts remaining:" + counter);
                    progressDialog.dismiss();
                    if(counter == 0){
                        eLogin.setEnabled(false);
                    }
                }
            }
        });
    }


}

