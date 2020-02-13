package com.rener.logbookapplication;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    private EditText NameR, PasswordR, EmailR;
    private Button RegButton;
    private TextView AlReadySignup;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        SetUpRegistration();

        firebaseAuth = FirebaseAuth.getInstance();

        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Conformation()){
                    //Upload to database
                    String user_email = EmailR.getText().toString().trim();
                    String user_password = PasswordR.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Registration.this, "Registration succelvol", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(Registration.this, com.rener.logbookapplication.LoginScreen.class));
                            }
                            else{
                                    Toast.makeText(Registration.this, "Registration Failed, An error accured", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

        AlReadySignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, com.rener.logbookapplication.LoginScreen.class));
            }
        });
    }

    private void SetUpRegistration(){
        NameR = (EditText) findViewById(R.id.txtNameR);
        PasswordR = (EditText) findViewById(R.id.txtPasswordR1);
        EmailR = (EditText) findViewById(R.id.txtEmail);
        RegButton = (Button) findViewById(R.id.btnRegistration);
        AlReadySignup = (TextView) findViewById(R.id.txtAlreadySignup);
    }

    private boolean Conformation(){
        boolean result = false;

        String name = NameR.getText().toString();
        String password = PasswordR.getText().toString();
        String email = EmailR.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty())
        {
            Toast.makeText(this, "Please enter all", Toast.LENGTH_SHORT).show();
        }
        else
        {
            result = true;
        }
        return result;
    }
}
