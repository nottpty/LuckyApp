package com.example.sas_maxnot19.luckyapp.views;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sas_maxnot19.luckyapp.R;
//import com.example.sas_maxnot19.luckyapp.models.Item;
import com.example.sas_maxnot19.luckyapp.models.Location;

import java.util.ArrayList;

/**
 * Created by SAS-Maxnot19 on 7/5/2559.
 */
public class LocationGridView extends ArrayAdapter<Location> {

    Context context;
    int layoutResourceId;
    ArrayList<Location> data = new ArrayList<Location>();

    public LocationGridView(Context context, int layoutResourceId,
                                 ArrayList<Location> data) {
        super(context, layoutResourceId,data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        Log.e("rrrr" , data.size()+"");
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;
        Log.e("oooo" , row + "");
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
            holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        Location item = data.get(position);
        Log.e("XXXX" , item.getTitle());
        holder.txtTitle.setText(item.getTitle());
        holder.imageItem.setImageBitmap(item.getImage());
        return row;

    }

     class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;

    }
}
