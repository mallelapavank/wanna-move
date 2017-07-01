package com.pavanmallela.wannamove;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pavanmallela.wannamove.databinding.PackersListAdapterItemBinding;
import com.pavanmallela.wannamove.model.PackersList;

import java.util.ArrayList;

/**
 * Created by agilan-3269 on 01/07/17.
 */

public class PackersListAdapter extends RecyclerView.Adapter<PackersListAdapter.PackersListViewHolder> {

    private AppCompatActivity activity;
    private ArrayList<PackersList> packersLists;

    public PackersListAdapter(ArrayList<PackersList> packersList, AppCompatActivity activity) {
        this.activity = activity;
        this.packersLists = packersList;
    }

    @Override
    public PackersListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PackersListViewHolder(PackersListAdapterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(PackersListViewHolder holder, int position) {
        holder.bind(packersLists.get(position));
    }

    @Override
    public int getItemCount() {
        return packersLists.size();
    }

    class PackersListViewHolder extends RecyclerView.ViewHolder {

        private final String TAG=PackersListViewHolder.class.getName();

        PackersListAdapterItemBinding binding;

        public PackersListViewHolder(PackersListAdapterItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PackersList packersList) {
            binding.setPacker(packersList);
            binding.showInterest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //send notification
                    Log.d(TAG,"onClick");
                }
            });
        }
    }

}
