package com.ghmc.biswajeet.ghmcrating;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by biswajeet on 9/2/17.
 */
public class ItemAdapter extends ArrayAdapter<AreaRatingItem> {

    public ItemAdapter(Context context, List<AreaRatingItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View newView = convertView;
        if (newView == null) {
            newView = LayoutInflater.from(getContext()).inflate(R.layout.arealist, null);
        }

        AreaRatingItem item = getItem(position);
        TextView areaname = (TextView) newView.findViewById(R.id.area_name);
        areaname.setText(item.getArea());

        TextView arearating = (TextView) newView.findViewById(R.id.cleanrating);
        arearating.setText(item.getTotal_rating() / item.getRating_count()+"");

        return newView;
    }
}
