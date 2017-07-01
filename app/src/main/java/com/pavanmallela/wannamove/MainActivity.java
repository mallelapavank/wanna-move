package com.pavanmallela.wannamove;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
import com.pavanmallela.wannamove.databinding.ActivityMainBinding;
import com.pavanmallela.wannamove.model.HouseListing;

public class MainActivity extends AppCompatActivity implements GridClickInterface{

    private static final String TAG=MainActivity.class.getName();

    GridViewAdapter gridViewAdapter;

    ActivityMainBinding binding;

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        MobileAds.initialize(this, "pub-8830992348050170");


        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        gridViewAdapter=new GridViewAdapter(this);
        binding.gridView.setAdapter(gridViewAdapter);

        /*AdRequest request = new AdRequest.Builder().build();
        binding.adView.loadAd(request);*/

    }

    @Override
    public void onFindHouseClick() {
        Log.d(TAG,"onFindHouseClick");

        Intent intent=new Intent(this,HouseListing.class);
        startActivity(intent);

        Bundle params = new Bundle();
        params.putString("screen_name", "onFindHouseClick");
        mFirebaseAnalytics.logEvent("main_screen_clicks", params);
    }

    @Override
    public void onHirePAndM() {
        Log.d(TAG,"onHirePAndM");

        Bundle params = new Bundle();
        params.putString("screen_name", "onHirePAndM");
        mFirebaseAnalytics.logEvent("main_screen_clicks", params);

        Intent intent=new Intent(this,PackersListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onHireRentalServices() {
        Log.d(TAG,"onHireRentalServices");

        Bundle params = new Bundle();
        params.putString("screen_name", "onHireRentalServices");
        mFirebaseAnalytics.logEvent("main_screen_clicks", params);

    }
}
