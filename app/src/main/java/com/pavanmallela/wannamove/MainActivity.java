package com.pavanmallela.wannamove;

import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pavanmallela.wannamove.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements GridClickInterface{

    private static final String TAG=MainActivity.class.getName();

    GridViewAdapter gridViewAdapter;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        gridViewAdapter=new GridViewAdapter(this);
        binding.gridView.setAdapter(gridViewAdapter);

    }

    @Override
    public void onFindHouseClick() {
        Log.d(TAG,"onFindHouseClick");
    }

    @Override
    public void onHirePAndM() {
        Log.d(TAG,"onHirePAndM");
    }

    @Override
    public void onHireRentalServices() {
        Log.d(TAG,"onHireRentalServices");
    }
}
