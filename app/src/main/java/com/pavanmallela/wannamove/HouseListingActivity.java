package com.pavanmallela.wannamove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pavanmallela.wannamove.model.HouseListing;

public class HouseListingActivity extends AppCompatActivity {

    String TAG = "HouseListingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_listing);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refHouseListing = database.getReference("data").child("HouseListing");
        refHouseListing.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange: "+ dataSnapshot.getValue(HouseListing.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "onCancelled: " + databaseError.getMessage() );
            }
        });

    }

}
