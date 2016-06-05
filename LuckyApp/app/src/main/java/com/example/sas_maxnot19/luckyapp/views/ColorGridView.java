package com.example.sas_maxnot19.luckyapp.views;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.sas_maxnot19.luckyapp.R;

import java.util.ArrayList;

/**
 * Created by SAS-Maxnot19 on 20/5/2559.
 */
public class ColorGridView extends ArrayAdapter<Integer> {

        Context context;
        int layoutResourceId;
        ArrayList<Integer> data = new ArrayList<Integer>();

        public ColorGridView(Context context, int layoutResourceId,
        ArrayList<Integer> data) {
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
            //holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
            holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        Integer item = data.get(position);
        //Log.e("XXXX" , item.getTitle());
        //holder.txtTitle.setText(item.getTitle());
        holder.imageItem.setBackgroundColor(item);
        return row;

    }

        class RecordHolder {
            //TextView txtTitle;
            ImageView imageItem;

        }
}
