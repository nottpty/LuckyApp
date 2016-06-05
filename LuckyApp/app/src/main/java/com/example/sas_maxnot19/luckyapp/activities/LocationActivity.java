package com.example.sas_maxnot19.luckyapp.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.GridView;

import com.example.sas_maxnot19.luckyapp.R;
import com.example.sas_maxnot19.luckyapp.models.Item;
import com.example.sas_maxnot19.luckyapp.models.Location;
import com.example.sas_maxnot19.luckyapp.views.CustomGridViewAdapter;
import com.example.sas_maxnot19.luckyapp.views.LocationGridView;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity {

    private GridView gridView;
    private  ArrayList<Location> gridArray = new ArrayList<Location>();
    private LocationGridView customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        initComponents();
    }

    public void initComponents(){
        setTitle("Location");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4081")));

        //set grid view item
        Bitmap parkIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.amusement_park);
        Bitmap storeIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.department_store);
        Bitmap mountainIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.mountain);
        Bitmap seaIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.sea);
        //Bitmap templeIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.tample);

        gridArray.add(new Location(parkIcon,"Park"));
        gridArray.add(new Location(storeIcon,"Department Store"));
        gridArray.add(new Location(mountainIcon,"Mountain"));
        gridArray.add(new Location(seaIcon,"Sea"));
        //gridArray.add(new Location(templeIcon,"Temple"));

        gridView = (GridView) findViewById(R.id.gridView);
        customGridAdapter = new LocationGridView(this, R.layout.location_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
        gridView.setClickable(false);
    }
    

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
