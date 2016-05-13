package com.example.sas_maxnot19.luckyapp.activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.sas_maxnot19.luckyapp.R;
import com.example.sas_maxnot19.luckyapp.models.Profile;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DressingActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dressing);
        initComponents();
    }

    public void initComponents(){
        setTitle("Dressing");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4081")));

        listView = (ListView) findViewById(R.id.listView);
        color = new ArrayList<String>();
        Constant.profile = getProfile();

        Log.e("date",Constant.profile.getDate().getDate()+"/"+(Constant.profile.getDate().getMonth()+1)+"/"+(Constant.profile.getDate().getYear()+1900));


    }

    public Profile getProfile() {
        SharedPreferences sp = getSharedPreferences(Constant.PROFILE_KEY,MODE_PRIVATE);
        Gson gson = new Gson();
        String profileStr = sp.getString("profile",null);
        return gson.fromJson(profileStr,Profile.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

