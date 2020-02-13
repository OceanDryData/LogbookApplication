package com.rener.logbookapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondScreen extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondscreen);

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

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNewLog:
                startActivity(new Intent(SecondScreen.this, com.rener.logbookapplication.NewLogScreen.class));
                break;
            case R.id.btnMaintenance:
                break;
            case R.id.btnAddUserInfo:
                startActivity(new Intent(SecondScreen.this, com.rener.logbookapplication.InfoRegistrationScreen.class));
                break;
            case R.id.btnUserInfo:
                startActivity(new Intent(SecondScreen.this, com.rener.logbookapplication.InfoScreen.class));
                break;
            case R.id.btnLogs:
                break;
            case R.id.btnGpsTracking:
                break;
        }

    }


}
