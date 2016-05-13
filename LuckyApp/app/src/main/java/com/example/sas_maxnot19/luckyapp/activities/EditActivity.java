package com.example.sas_maxnot19.luckyapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sas_maxnot19.luckyapp.R;

public class EditActivity extends AppCompatActivity {
    private TextView edit_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initComponents();
    }

    public void initComponents(){
        setTitle("Edit your profile");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4081")));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
