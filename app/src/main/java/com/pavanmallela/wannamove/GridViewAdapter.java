package com.pavanmallela.wannamove;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by agilan-3269 on 01/07/17.
 */

public class GridViewAdapter extends BaseAdapter {

    private AppCompatActivity activity;

    private String[] features = new String[]{"Find House", "Hire Packers & Movers", "Hire Settling Services"};
    private int[] images = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private String[] bgColor = new String[]{"#00FFFF", "#FF00FF", "#FFFF00"};
    private String[] textColor = new String[]{"#FF0000", "#00FF00", "#0000FF"};

    GridViewAdapter(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return features.length;
    }

    @Override
    public String getItem(int position) {
        return features[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.grid_view_item, parent, false);

            LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.grid_item_parent);
            linearLayout.setBackgroundColor(Color.parseColor(bgColor[position]));

            TextView title = (TextView) convertView.findViewById(R.id.name);
            title.setText(features[position]);
            title.setTextColor(Color.parseColor(textColor[position]));

            ImageView image = (ImageView) convertView.findViewById(R.id.image);
            image.setImageResource(images[position]);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (features[position]) {
                        case "Find House":
                            ((MainActivity) activity).onFindHouseClick();
                            break;
                        case "Hire Packers & Movers":
                            ((MainActivity) activity).onHirePAndM();
                            break;
                        case "Hire Settling Services":
                            ((MainActivity) activity).onHireRentalServices();
                            break;
                    }
                }
            });

        }
        return convertView;
    }
}
