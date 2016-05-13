package com.example.sas_maxnot19.luckyapp.activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sas_maxnot19.luckyapp.R;
import com.example.sas_maxnot19.luckyapp.models.Profile;
import com.google.gson.Gson;

public class AccessoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessory);
        initComponents();
    }

    public void initComponents(){
        setTitle("Accessories");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4081")));
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
