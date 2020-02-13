package com.rener.logbookapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class MenuScreen  extends AppCompatActivity implements View.OnClickListener {


    private FirebaseAuth firebaseAuth;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuscreen);

        Button btnNewLog = findViewById(R.id.btnNewLog);
        Button btnMaintenance = findViewById(R.id.btnMaintenance);
        Button btnLogs = findViewById(R.id.btnLogs);
        Button btnUserInfo = findViewById(R.id.btnUserInfo);
        Button btnAddUserInfo = findViewById(R.id.btnAddUserInfo);
        Button btnGpsTracking = findViewById(R.id.btnGpsTracking);

        btnNewLog.setOnClickListener(this);
        btnMaintenance.setOnClickListener(this);
        btnLogs.setOnClickListener(this);
        btnUserInfo.setOnClickListener(this);
        btnAddUserInfo.setOnClickListener(this);
        btnGpsTracking.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();

        logout = (Button)findViewById(R.id.btnLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNewLog:
                startActivity(new Intent(MenuScreen.this, com.rener.logbookapplication.NewLogScreen.class));
                break;
            case R.id.btnMaintenance:
                break;
            case R.id.btnAddUserInfo:
                startActivity(new Intent(MenuScreen.this, com.rener.logbookapplication.InfoRegistrationScreen.class));
                break;
            case R.id.btnUserInfo:
                startActivity(new Intent(MenuScreen.this, com.rener.logbookapplication.InfoScreen.class));
                break;
            case R.id.btnLogs:
                break;
            case R.id.btnGpsTracking:
                break;
        }

    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(MenuScreen.this, LoginScreen.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.logoutMenu:{
                Logout();
                break;
            }
            case R.id.profileMenu:
                startActivity(new Intent(MenuScreen.this, YachtProfileScreen.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}