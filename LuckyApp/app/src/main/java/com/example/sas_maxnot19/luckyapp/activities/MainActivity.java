package com.example.sas_maxnot19.luckyapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sas_maxnot19.luckyapp.R;
import com.example.sas_maxnot19.luckyapp.models.Item;
import com.example.sas_maxnot19.luckyapp.models.Profile;
import com.example.sas_maxnot19.luckyapp.views.CustomGridViewAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    public void initComponent(){
        setTitle("Main Menu");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4081")));

        //set grid view item
        Bitmap dressingIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.dressing);
        Bitmap friendIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.friend);
        //Bitmap recommendIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.recommend);
        Bitmap activitiesIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.activities);
        Bitmap locationIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.location);
        Bitmap accessoriesIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.accessories);

        gridArray.add(new Item(dressingIcon,"Dressing",DressingActivity.class));
        gridArray.add(new Item(friendIcon,"Friend",FriendActivity.class));
        //gridArray.add(new Item(recommendIcon,"Recommend",RecommendActivity.class));
        gridArray.add(new Item(activitiesIcon,"Activities",Activities_Activity.class));
        gridArray.add(new Item(locationIcon,"Location",LocationActivity.class));
        gridArray.add(new Item(accessoriesIcon,"Accessories",AccessoryActivity.class));

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                Item item = gridArray.get(position);
                Class nextAct = item.getActivityClass();
                Intent intent = new Intent(MainActivity.this , nextAct);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.goToProfile:
                gotoProfile();
                break;
            case R.id.gotoLogin:
                gotoLogin();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gotoProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void gotoLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
