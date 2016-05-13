package com.example.sas_maxnot19.luckyapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sas_maxnot19.luckyapp.R;
import com.example.sas_maxnot19.luckyapp.models.Profile;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if(isExist()){
                    gotoMain();
                }else{
                    gotoLogin();
                }
                finish();
            }
        },2000);

    }

    public boolean isExist() {
        SharedPreferences sp = getSharedPreferences(Constant.PROFILE_KEY , MODE_PRIVATE);
        String profileStr = sp.getString("profile" , null);
        if(profileStr == null) return false;
        return true;
    }

    public void gotoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void gotoLogin() {
        Intent intent = new Intent(this , LoginActivity.class);
        startActivity(intent);
    }
}
