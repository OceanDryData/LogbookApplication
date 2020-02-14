package com.rener.logbookapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rener.logbookapplication.Model.YachtProfile;

import androidx.appcompat.app.AppCompatActivity;

public class YachtProfileScreen extends AppCompatActivity

    {

    private TextView profileName, profileLength,profileBoatYear,profileMarina,profileBox;
    private Button profileUpdate, changePassword;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
//    private FirebaseStorage firebaseStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yachtprofile);

        profileName = findViewById(R.id.tvName);
        profileLength = findViewById(R.id.tvLength);
        profileBoatYear = findViewById(R.id.tvYear);
        profileMarina = findViewById(R.id.tvMarina);
        profileBox = findViewById(R.id.tvBox);
        profileUpdate = findViewById(R.id.btnProfileUpdate);
        changePassword = findViewById(R.id.btnChangePassword);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

//        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid()).child("YachtProfile");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                YachtProfile yachtProfile = dataSnapshot.getValue(YachtProfile.class);
                profileName.setText("Name: " + yachtProfile.getName());
                profileLength.setText("Length: " + yachtProfile.getLength());
                profileBoatYear.setText("Boat Year: " + yachtProfile.getYear());
                profileMarina.setText("Marina: " + yachtProfile.getMarina());
                profileBox.setText("Box: " + yachtProfile.getBox());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(YachtProfileScreen.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        profileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YachtProfileScreen.this, UpdateProfileScreen.class));
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(YachtProfileScreen.this, UpdatePassword.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
