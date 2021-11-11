package com.example.localhangout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class SignUp extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIView();

        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //upload data to the database
                    String user_email = userEmail.getText().toString().trim(); //.trim() to remove the white spaces
                    String user_password = userPassword.getText().toString().trim();


                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //tell user if the task is successful
                            if(task.isSuccessful()){
                                Toast.makeText(SignUp.this, "Registration Successful",Toast.LENGTH_SHORT).show();

                                //go back to login if successfull. Testing only, will implement next page later
                                startActivity(new Intent(SignUp.this, Login.class));
                            }else{
                                Toast.makeText(SignUp.this, "Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

         userLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(SignUp.this,Login.class ));
             }
         });
    }

    private void setupUIView(){
        userName = findViewById(R.id.etUserName);
        userPassword = findViewById(R.id.etUserPassword);
        userEmail = findViewById(R.id.etUserEmail);
        regButton = findViewById(R.id.btnSignUp);
        userLogin = findViewById(R.id.tvUserLogin);
    }

    private Boolean validate(){
        Boolean result = false;
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty()&&password.isEmpty()&&email.isEmpty()){
            Toast.makeText( this,"Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }
        return result;
    }

}