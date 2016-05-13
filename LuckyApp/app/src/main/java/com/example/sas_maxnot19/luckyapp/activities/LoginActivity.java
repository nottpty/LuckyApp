package com.example.sas_maxnot19.luckyapp.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.sas_maxnot19.luckyapp.R;
import com.example.sas_maxnot19.luckyapp.models.Profile;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoginActivity extends AppCompatActivity {
    private TextView firstname_tv;
    private TextView lastname_tv;
    private TextView birthday_tv;
    private TextView timeOfBirth_tv;

    private int hour;
    private int minute;

    private TextView submit_btn;
    private TextView reset_btn;
    private RadioButton male_rdb;
    private RadioButton female_rdb;
    private Date userDate = new Date();
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("PROFILE", Context.MODE_PRIVATE);
        initComponents();
    }

    private void initComponents(){
        setTitle("Enter your profile");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4081")));
        firstname_tv = (TextView) findViewById(R.id.firstname_tv);
        lastname_tv = (TextView) findViewById(R.id.lastname_tv);
        reset_btn = (TextView) findViewById(R.id.reset_btn);
        submit_btn = (TextView) findViewById(R.id.submit_btn);
        male_rdb = (RadioButton) findViewById(R.id.male_rdb);

        submit_btn = (TextView) findViewById(R.id.submit_btn);

        male_rdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female_rdb.setChecked(false);
            }
        });
        female_rdb = (RadioButton) findViewById(R.id.female_rdb);
        female_rdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male_rdb.setChecked(false);
            }
        });
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname_tv.setText("");
                lastname_tv.setText("");
                birthday_tv.setText("Press to choose");
                timeOfBirth_tv.setText("Press to choose");
                male_rdb.setChecked(false);
                female_rdb.setChecked(false);
            }
        });
        final Date date = new Date();
        date.setTime(System.currentTimeMillis());
        timeOfBirth_tv = (TextView) findViewById(R.id.timeOfBirthday_tv);
        birthday_tv = (TextView) findViewById(R.id.birthday_tv);

        timeOfBirth_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                hour = currentTime.get(Calendar.HOUR_OF_DAY);
                minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(LoginActivity.this,new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker timePicker,int selectedHour, int selectedMinute){
                        userDate.setHours(hour);
                        userDate.setMinutes(minute);
                        timeOfBirth_tv.setText(selectedHour+":"+selectedMinute);
                    }
                }, userDate.getHours(), userDate.getMinutes(), true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        birthday_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(LoginActivity.this,listener,date.getYear()+1900,date.getMonth(),date.getDay()).show();
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Profile profile = new Profile(firstname_tv.getText().toString() ,
                        lastname_tv.getText().toString(),
                        userDate , male_rdb.isChecked());
                Constant.profile = profile;
                createNewProfile(profile);
                gotoMain();
            }
        });


    }



    public void createNewProfile(Profile profile) {
        Gson gson = new Gson();
        SharedPreferences.Editor editor = getSharedPreferences(Constant.PROFILE_KEY, MODE_PRIVATE).edit();
        editor.putString("profile" , gson.toJson(profile));
        editor.apply();
    }

    public void gotoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }



    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            userDate.setDate(dayOfMonth);
            userDate.setMonth(monthOfYear);
            userDate.setYear(year-1900);
            DateFormat format = new SimpleDateFormat("dd MMM yyyy");
            birthday_tv.setText(format.format(userDate));
        }
    };

}
