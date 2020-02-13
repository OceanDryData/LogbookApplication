package com.rener.logbookapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rener.logbookapplication.Model.Log;

import androidx.appcompat.app.AppCompatActivity;

public class NewLogScreen extends AppCompatActivity {

    DatabaseReference reff;
    Log log;

    private EditText logName;
    private Button btnsaveLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newlog);

        logName = (EditText) findViewById(R.id.etLogName);
        btnsaveLog = (Button)findViewById(R.id.btnSaveLog);

        log = new Log();
        reff = FirebaseDatabase.getInstance().getReference().child("Log");


        btnsaveLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                log.setName(logName.getText().toString().trim());
                reff.push().setValue(log);
                Toast.makeText(NewLogScreen.this, "data inserted",Toast.LENGTH_LONG).show();

                setContentView(R.layout.activity_secondscreen);
            }
        });

    }

}
