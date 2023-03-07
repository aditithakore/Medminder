package com.example.demo;

import static java.util.ResourceBundle.getBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class set_reminder extends AppCompatActivity {

    Button btnMed,btnApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);

        btnMed=findViewById(R.id.btn_med);
        btnApp=findViewById(R.id.btn_app);

        Intent frmdb=getIntent();
        String userid=frmdb.getStringExtra("user_id");
        Log.d("data_sr","data= "+userid);

        btnMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),medicine.class);
                intent.putExtra("user_id",userid);
                startActivity(intent);
                Log.d("data_inMedd","data= "+userid);

            }
        });

        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),appointment.class);
                intent.putExtra("user_id",userid);
                startActivity(intent);
                Log.d("data_inAppoint","data= "+userid);

            }
        });


    }

    int counter=0;
    @Override
    public void onBackPressed() {
        counter++;
        if(counter==1){
            Intent intent=new Intent(getApplicationContext(),dashboard.class);
            Intent frmdb=getIntent();
            String userid=frmdb.getStringExtra("user_id");


            Log.d("data_sr-db","data= "+userid);
           intent.putExtras(frmdb);
            startActivity(intent);
            Log.d("data_dbfrmsr","data= "+userid);

        }
        else{
            super.onBackPressed();
        }
    }
}