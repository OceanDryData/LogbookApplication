package com.rener.logbookapplication;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    private TextView NewAccount;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);

        Name = (EditText) findViewById (R.id.txtName);
        Password = (EditText) findViewById(R.id.txtPassword);
        Info = (TextView) findViewById(R.id.txtvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        NewAccount = (TextView) findViewById(R.id.txtNewRegistration);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null)
        {
            finish();
            startActivity(new Intent(LoginScreen.this, com.rener.logbookapplication.MenuScreen.class));
        }

        Info.setText("Remaining attempts: " + counter);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginapp(Name.getText().toString(), Password.getText().toString());

            }
        });

        NewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginScreen.this,com.rener.logbookapplication.Registration.class   ));
            }
        });
    }

    private void loginapp(final String userName, final String userPassword){

        progressDialog.setMessage("Loading");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Toast.makeText(LoginScreen.this, "Login Succesvol", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginScreen.this, com.rener.logbookapplication.MenuScreen.class));
                }
                else {

                    Toast.makeText(LoginScreen.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                    counter--;
                    Info.setText("Remaining attempts: " + counter);


                    if (counter == 0) {
                        Login.setEnabled(false);
                    }
                }
            }
        });
    }
}

