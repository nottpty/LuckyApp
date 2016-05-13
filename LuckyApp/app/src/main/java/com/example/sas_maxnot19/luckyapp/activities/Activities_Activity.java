package com.example.sas_maxnot19.luckyapp.activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sas_maxnot19.luckyapp.R;

import java.util.ArrayList;
import java.util.List;

public class Activities_Activity extends AppCompatActivity {

    private List<String> activities;
    private TextView activities_tv;
    private int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_);
        initComponents();
    }

    public void initComponents(){
        setTitle("Activities");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4081")));
        activities_tv = (TextView) findViewById(R.id.activity_tv);
        setActivities();
        random = random(activities.size());
        for(int i = 0 ; i < activities.size() ; i++){
            if(random == i){
                activities_tv.setText(activities.get(i));
            }
        }
    }

    public int random(int size){
        int n = (int)Math.ceil(Math.random()*size-1);
        return n;
    }

    public void setActivities(){
        activities = new ArrayList<String>();
        activities.add("You should do goodness.");
        activities.add("You should go night market.");
        activities.add("You should go to see movie.");
        activities.add("You should play game.");
        activities.add("You should do your work.");
        activities.add("You should making love.");
        activities.add("You should go department store.");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
