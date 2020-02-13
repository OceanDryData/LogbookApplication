package com.rener.logbookapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rener.logbookapplication.Model.YachtProfile;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateProfileScreen  extends AppCompatActivity {

    private EditText  newName, newLength,newBoatYear,newMarina, newBox;
    private Button save;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvitiy_update_profile);

        newName = findViewById(R.id.tbRYachtName);
        newLength = findViewById(R.id.tbRLength);
        newBoatYear = findViewById(R.id.tbRYear);
        newMarina = findViewById(R.id.tbRMarina);
        newBox = findViewById(R.id.tbRBoxNumber);

        save = findViewById(R.id.btnSave);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

//        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        final DatabaseReference databaseReference = firebaseDatabase.getReference().child("YachtProfileScreen");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                YachtProfile yachtProfile = dataSnapshot.getValue(YachtProfile.class);
                newName.setText("Name: " + yachtProfile.getName());
                newLength.setText("Length: " + yachtProfile.getLength());
                newBoatYear.setText("Boat Year: " + yachtProfile.getYear());
                newMarina.setText("Marina: " + yachtProfile.getMarina());
                newBox.setText("Box: " + yachtProfile.getBox());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(YachtProfile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = newName.getText().toString();
                String length = newLength.getText().toString();
                String year = newBoatYear.getText().toString();
                String marina = newMarina.getText().toString();
                String box = newBox.getText().toString();

                YachtProfile yachtProfile = new YachtProfile(name, length, year, marina,box);

                databaseReference.setValue(yachtProfile);

                finish();
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
