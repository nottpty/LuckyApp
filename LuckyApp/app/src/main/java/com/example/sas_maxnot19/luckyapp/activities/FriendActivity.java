package com.example.sas_maxnot19.luckyapp.activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sas_maxnot19.luckyapp.R;

import java.util.ArrayList;
import java.util.List;

public class FriendActivity extends AppCompatActivity {

    private List<String> friend;
    private TextView friend_tv;
    private int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        initComponents();
    }

    public void initComponents(){

        setTitle("Friend");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4081")));
        friendList();
        friend_tv = (TextView) findViewById(R.id.friend_tv);
        random = random(friend.size());
        for(int i = 0 ; i < friend.size() ; i++){
            if( random == i){
                friend_tv.setText(friend.get(i));
            }
        }
    }

    public int random(int size){
        int n = (int)Math.ceil(Math.random()*size-1);
        Log.e("index",n+"");
        return n;
    }

    public void friendList(){
        friend = new ArrayList<String>();
        friend.add("You should play with girlfriend");
        friend.add("You should contact with new friend");
        friend.add("You should talk with boy group");
        friend.add("You should talk with girl group");
        friend.add("You should contact with old friend");
        friend.add("You should play with boyfriend");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
