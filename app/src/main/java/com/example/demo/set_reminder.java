package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class set_reminder extends AppCompatActivity {

    //String user_dash_reminder="";



    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private MyFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);

        Intent frmdb=getIntent();
        String userid=frmdb.getStringExtra("user_id");

        Log.d("data_sr","data= "+userid);

//        Bundle bundle = getIntent().getExtras();
//        user_dash_reminder=bundle.getString("user_id");


        tabLayout=findViewById(R.id.tab);
        viewPager2=findViewById(R.id.viewpager2);


        tabLayout.addTab(tabLayout.newTab().setText("Medicine"));
        tabLayout.addTab(tabLayout.newTab().setText("Appointment"));

        FragmentManager fragmentManager= getSupportFragmentManager();
        adapter=new MyFragmentAdapter(fragmentManager,getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }

    int counter=0;
    @Override
    public void onBackPressed() {
        counter++;
        if(counter==1){
//
//            Bundle bundle_dash= new Bundle();
//            bundle_dash.putString("user_id", user_dash_reminder);
            Intent intent=new Intent(getApplicationContext(),dashboard.class);
            Intent frmdb=getIntent();
            String userid=frmdb.getStringExtra("user_id");


            Log.d("data_sr-db","data= "+userid);
           intent.putExtras(frmdb);
//
//            Log.d("data_rem","data= "+bundle_dash.getString("user_id"));
            startActivity(intent);
            Log.d("data_dbfrmsr","data= "+userid);
           // super.onBackPressed();
        }
        else{
            super.onBackPressed();
        }
    }
}