package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class viewList extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private viewListFragmentAdapter viewListFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        Intent frmdb=getIntent();
        String userid=frmdb.getStringExtra("user_id");
        Log.d("data_vl","data= "+userid);

       Bundle bundle=new Bundle();
       bundle =getIntent().getExtras();

        Log.d("data_vlofbundle","data= "+bundle);

    //    bundle.putString("user_id", userid);
     //   AppointmentList.setArguments(bundle);
       // Log.d("data_VL","data= "+getIntent().getExtras());
        //Log.d("data_VL","data= "+bundle.getString("user_id"));
//        Bundle bundle_frag = new Bundle();
//        bundle.putString("userId", bundle.getString("user_id"));
// set Fragmentclass Arguments
//        AppointmentList fragobj = new AppointmentList();
//        fragobj.setArguments(bundle_frag);


        tabLayout=findViewById(R.id.tab1);
        viewPager2=findViewById(R.id.vl_viewpager2);


        tabLayout.addTab(tabLayout.newTab().setText("Medicine"));
        tabLayout.addTab(tabLayout.newTab().setText("Appointment"));

        FragmentManager fragmentManager= getSupportFragmentManager();
        viewListFragmentAdapter=new viewListFragmentAdapter(fragmentManager,getLifecycle());
        viewPager2.setAdapter(viewListFragmentAdapter);

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
            Intent intent=new Intent(getApplicationContext(),dashboard.class);
            startActivity(intent);
        }
        else{
            super.onBackPressed();
        }



    }
}