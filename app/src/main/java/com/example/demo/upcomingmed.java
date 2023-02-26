package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;

import java.util.Calendar;

public class upcomingmed extends AppCompatActivity {

    ImageView dropdownCal;
    private int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomingmed);
        Intent frmup=getIntent();
        String userid=frmup.getStringExtra("user_id");
        Log.d("data_upMed","data= "+userid);







    }
}

