package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class upcoming extends AppCompatActivity {

    Button btnUpMed,btnUpApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);

        Intent frmdb=getIntent();
        String userid=frmdb.getStringExtra("user_id");
        Log.d("data_up","data= "+userid);

        btnUpMed=findViewById(R.id.btn_up_med);
        btnUpApp=findViewById(R.id.btn_up_app);

        btnUpMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(upcoming.this,upcomingmed.class);
                intent.putExtra("user_id",userid);
                startActivity(intent);
            }
        });

        btnUpApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(upcoming.this,upcomingapp.class);
                intent.putExtra("user_id",userid);
                startActivity(intent);
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
            Log.d("data_up-db","data= "+userid);
            intent.putExtras(frmdb);
            startActivity(intent);
            Log.d("data_dbfrmup","data= "+userid);

        }
        else{
            super.onBackPressed();
        }



    }
}