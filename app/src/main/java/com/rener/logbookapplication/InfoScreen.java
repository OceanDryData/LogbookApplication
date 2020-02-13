package com.rener.logbookapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

public class InfoScreen extends AppCompatActivity {

//   private TextView YachtName, YachtSize, YachtYear, YachtMarina, YachtBoxNumber;
//    public Button Edit;
//    private ImageView YachtPicture;
//
//    private FirebaseAuth firebaseAuth;
//    private FirebaseDatabase firebaseDatabase;
//    //String Yname, Ysize, Yyear, Ymarina, Ybox;

//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_info_screen);
//
//        YachtName = (TextView) findViewById(R.id.txtYachtName);
//        YachtSize = (TextView) findViewById(R.id.txtSize);
//        YachtYear = (TextView) findViewById(R.id.txtYear);
//        YachtMarina = (TextView) findViewById(R.id.txtMarina);
//        YachtBoxNumber= (TextView) findViewById(R.id.txtBoxnumber);
//
//        Edit = (Button) findViewById(R.id.btnEditInfo);
//
//
//        firebaseAuth = FirebaseAuth.getInstance();
//        firebaseDatabase = FirebaseDatabase.getInstance();
//
//       DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid()   );
//
//       databaseReference.addValueEventListener(new ValueEventListener() {
//           @Override
//           public void onDataChange(DataSnapshot dataSnapshot) {
//               com.rener.logbookapplication.YachtProfileScreen yachtProfile = dataSnapshot.getValue(com.rener.logbookapplication.YachtProfileScreen.class);
//                YachtName.setText(yachtProfile.getYachtNameC());
//                YachtSize.setText(yachtProfile.getYachtLengthC());
//                YachtYear.setText(yachtProfile.getYachtYearC());
//                YachtMarina.setText(yachtProfile.getYachtMarinaC());
//                YachtBoxNumber.setText(yachtProfile.getYachtBoxC());
//           }
//
//           @Override
//           public void onCancelled(DatabaseError databaseError) {
//               Toast.makeText(InfoScreen.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
//           }
//       });
//
//        Edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(InfoScreen.this, com.rener.logbookapplication.InfoRegistrationScreen.class);
//                startActivity(intent2);
//
//            }
//        });
//
//    }

}
