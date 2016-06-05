package com.example.sas_maxnot19.luckyapp.activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import com.example.sas_maxnot19.luckyapp.R;
import com.example.sas_maxnot19.luckyapp.models.Profile;
import com.example.sas_maxnot19.luckyapp.models.Zodiac;
import com.example.sas_maxnot19.luckyapp.views.ColorGridView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DressingActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<Integer> gridArray = new ArrayList<Integer>();
    private ColorGridView customGridAdapter;
    private Zodiac zodiac;

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

        Constant.profile = getProfile();
        zodiac = new Zodiac(Constant.profile.getDate().getDate(),Constant.profile.getDate().getMonth()+1);
        //Log.e("date",Constant.profile.getDate().getDate()+"/"+(Constant.profile.getDate().getMonth()+1)+"/"+(Constant.profile.getDate().getYear()+1900));
        Log.e("Zodiac: ",zodiac.getZodiac());

        if(zodiac.getZodiac()=="munggorn"){
            gridArray.add(Color.rgb(139,69,19));
            gridArray.add(Color.WHITE);
            gridArray.add(Color.BLACK);
        }
        else if(zodiac.getZodiac()=="gum"){
            gridArray.add(Color.BLUE);
            gridArray.add(Color.MAGENTA);
            gridArray.add(Color.YELLOW);
        }
        else if(zodiac.getZodiac()=="mean"){
            gridArray.add(Color.YELLOW);
            gridArray.add(Color.MAGENTA);
        }
        else if(zodiac.getZodiac()=="mezz"){
            gridArray.add(Color.RED);
            gridArray.add(Color.rgb(255,20,147));
            gridArray.add(Color.WHITE);
            gridArray.add(Color.YELLOW);
        }
        else if(zodiac.getZodiac()=="purzog"){
            gridArray.add(Color.rgb(255,20,147));
            gridArray.add(Color.rgb(255,222,173));
            gridArray.add(Color.WHITE);
            gridArray.add(Color.BLACK);
        }
        else if(zodiac.getZodiac()=="maetun"){
            gridArray.add(Color.GREEN);
            gridArray.add(Color.BLACK);
            gridArray.add(Color.WHITE);
            gridArray.add(Color.rgb(255,20,147));
            gridArray.add(Color.RED);
        }
        else if(zodiac.getZodiac()=="goragod"){
            gridArray.add(Color.BLUE);
            gridArray.add(Color.WHITE);
            gridArray.add(Color.GREEN);
            gridArray.add(Color.YELLOW);
            gridArray.add(Color.RED);
        }
        else if(zodiac.getZodiac()=="sing"){
            gridArray.add(Color.rgb(255,140,0));
            gridArray.add(Color.MAGENTA);
            gridArray.add(Color.RED);
            gridArray.add(Color.rgb(255,215,0));
        }
        else if(zodiac.getZodiac()=="gun"){
            gridArray.add(Color.rgb(255,20,147));
            gridArray.add(Color.BLUE);
            gridArray.add(Color.GREEN);
        }
        else if(zodiac.getZodiac()=="tlun"){
            gridArray.add(Color.BLUE);
            gridArray.add(Color.WHITE);
            gridArray.add(Color.rgb(255,20,147));
            gridArray.add(Color.BLACK);
        }
        else if(zodiac.getZodiac()=="pijig"){
            gridArray.add(Color.RED);
            gridArray.add(Color.MAGENTA);
            gridArray.add(Color.rgb(139,69,19));
            gridArray.add(Color.GREEN);
        }
        else if(zodiac.getZodiac()=="tanu"){
            gridArray.add(Color.YELLOW);
            gridArray.add(Color.BLUE);
            gridArray.add(Color.RED);
            gridArray.add(Color.WHITE);
            gridArray.add(Color.rgb(255,140,0));
        }

        gridView = (GridView) findViewById(R.id.gridView);
        Log.e("Gridciew",gridView+"");
        customGridAdapter = new ColorGridView(this, R.layout.color_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
        gridView.setClickable(false);
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

