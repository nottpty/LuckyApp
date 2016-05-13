package com.example.sas_maxnot19.luckyapp.activities;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.sas_maxnot19.luckyapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloActivity extends AppCompatActivity {
    private TextView textView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        textView = (TextView)findViewById(R.id.textView3);
        //btn = (Button)findViewById(R.id.button);
        final Date date = new Date();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new DatePickerDialog(HelloActivity.this , listener , date.getYear(), date.getMonth() , date.getDate() ).show();
//            }
//        });
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                new DatePickerDialog(HelloActivity.this , listener , date.getYear(), date.getMonth() , date.getDate() ).show();
            }
        });

    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Date date = new Date();
            date.setYear(year);
            date.setMonth(monthOfYear);
            date.setDate(dayOfMonth);
            DateFormat format = new SimpleDateFormat("yy MMM yyyy");
            textView.setText(format.format(date));
        }
    };
}
