package com.rener.logbookapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rener.logbookapplication.Model.YachtProfile;

import androidx.appcompat.app.AppCompatActivity;

public class InfoRegistrationScreen extends AppCompatActivity {

    DatabaseReference reff;
    YachtProfile yachtProfile;

    private EditText Rname, Rlength, RYear, RMarina, RBox;
    private Button btnSaveInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info_registration_screen);

       Rname = (EditText) findViewById(R.id.tbRYachtName);
       Rlength = (EditText) findViewById(R.id.tbRLength);
       RYear = (EditText) findViewById(R.id.tbRYear);
       RMarina = (EditText) findViewById(R.id.tbRMarina);
       RBox = (EditText) findViewById(R.id.tbRBoxNumber);

        btnSaveInfo = (Button) findViewById(R.id.btnSaveRegInfo);

        yachtProfile = new YachtProfile();
        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
        reff = FirebaseDatabase.getInstance().getReference().child("YachtProfileScreen");


        btnSaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String currentUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//                yachtProfile.setUserid(currentUid);
            yachtProfile.setName(Rname.getText().toString().trim());
            yachtProfile.setLength(Rlength.getText().toString().trim());
            yachtProfile.setYear(RYear.getText().toString().trim());
            yachtProfile.setMarina(RMarina.getText().toString().trim());
            yachtProfile.setBox(RBox.getText().toString().trim());
            reff.push().setValue(yachtProfile);
            Toast.makeText(InfoRegistrationScreen.this, "data inserted",Toast.LENGTH_LONG).show();
            }
        });

    }


}