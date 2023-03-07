package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class viewList extends AppCompatActivity {

    Button btnVlMed,btnVlApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        Intent frmdb=getIntent();
        String userid=frmdb.getStringExtra("user_id");
        Log.d("data_vl","data= "+userid);

        btnVlMed=findViewById(R.id.btn_vl_med);
        btnVlApp=findViewById(R.id.btn_vl_app);

        btnVlMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),medicineCardList.class);
                intent.putExtra("user_id",userid);
                startActivity(intent);
                Log.d("dataaa_inVlMed","data= "+userid);
            }
        }
        );

        btnVlApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),appointment_List.class);
                intent.putExtra("user_id",userid);
                startActivity(intent);
                Log.d("dataaa_inVlApp","data= "+userid);
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
            Log.d("data_vl-db","data= "+userid);
            intent.putExtra("user_id",userid);
            startActivity(intent);
        }
        else{
            super.onBackPressed();
        }



    }
}