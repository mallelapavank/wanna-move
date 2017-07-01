package com.pavanmallela.wannamove;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pavanmallela.wannamove.databinding.ActivityPackersListBinding;
import com.pavanmallela.wannamove.model.PackersList;

import java.util.ArrayList;

/**
 * Created by agilan-3269 on 01/07/17.
 */

public class PackersListActivity extends AppCompatActivity {

    private static final String TAG=PackersListActivity.class.getName();

    private DatabaseReference mDatabase;

    ActivityPackersListBinding binding;

    ArrayList<PackersList> packersLists;

    PackersListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_packers_list);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        binding.progressBar.setVisibility(View.VISIBLE);

        mDatabase.child("data").child("packersList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Log.d(TAG,"dataSnapshot");
                    PackersList packersList = dataSnapshot.getValue(PackersList.class);
                    if(packersLists!=null) {
                        packersLists.clear();
                    }else{
                        packersLists=new ArrayList<PackersList>();
                    }
                    packersLists.add(packersList);
                    setAdapter();
                    binding.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void setAdapter(){
        if(adapter!=null){
            adapter.notifyDataSetChanged();
        }else{
            adapter=new PackersListAdapter(packersLists,this);
            binding.packersList.setLayoutManager(new LinearLayoutManager(this));
            binding.packersList.setAdapter(adapter);
        }
    }
}
