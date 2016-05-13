package com.example.sas_maxnot19.luckyapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.sas_maxnot19.luckyapp.R;
import com.example.sas_maxnot19.luckyapp.models.Profile;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProfileActivity extends AppCompatActivity {
    private TextView firstname_tv;
    private TextView lastname_tv;
    private TextView birthday_tv;
    private TextView timeOfBirth_tv;
    private RadioButton male_rdb, female_rdb;

    private TextView edit_tv;
    private TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initComponent();
    }

    private void initComponent(){
        setTitle("Profile");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4081")));
        //profile = (Profile)getIntent().getSerializableExtra("profile");
        //Log.e("Firstname", profile.getFirstname());
        edit_tv = (TextView)findViewById(R.id.edit_btn);
        edit_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });

        back = (TextView)findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Profile profile = getProfile();
        //Constant.profile = getProfile();
        DateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
        male_rdb = (RadioButton) findViewById(R.id.male_rdb);
        female_rdb = (RadioButton) findViewById(R.id.female_rdb);
        male_rdb.setChecked(profile.isMale());
        female_rdb.setChecked(!profile.isMale());
        firstname_tv = (TextView) findViewById(R.id.firstname_tv);
        firstname_tv.setText(profile.getFirstname());
        lastname_tv = (TextView) findViewById(R.id.lastname_tv);
        lastname_tv.setText(profile.getLastname());
        birthday_tv = (TextView) findViewById(R.id.birthday_tv);
        birthday_tv.setText(format.format(profile.getDate()));
        timeOfBirth_tv = (TextView) findViewById(R.id.timeOfBirthday_tv);
        timeOfBirth_tv.setText(String.format("%2d:%2d" , profile.getDate().getHours() , profile.getDate().getMinutes()));
    }

    public Profile getProfile() {
        SharedPreferences sp = getSharedPreferences(Constant.PROFILE_KEY,MODE_PRIVATE);
        Gson gson = new Gson();
        String profileStr = sp.getString("profile",null);
        return gson.fromJson(profileStr,Profile.class);
    }


}
