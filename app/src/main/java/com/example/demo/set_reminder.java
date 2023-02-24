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

    //String user_dash_reminder="";



    Button btnMed,btnApp;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
//    private MyFragmentAdapter adapter;
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

//
//        Bundle bundle=new Bundle();
//        bundle.putString("user_id",userid);
//        Log.d("data_bundle","data= "+bundle);







//        addmedicine fragment = new addmedicine();
//
//        List<String> myData = new ArrayList<>();
//        myData.add("user_id");
//
//        MyFragmentAdapter adapter = new MyFragmentAdapter();
//        adapter.setData(myData);
//
//        getSupportFragmentManager().beginTransaction().add(R.id.LL_sr, fragment).commit();




//        addmedicine fragment = new addmedicine();
//        Bundle args = new Bundle();
//        ArrayList<String> data = new ArrayList<>();
//        data.add(0,"user_id");
//        args.putStringArrayList(" ",data);
//        fragment.setArguments(args);



//        MyFragmentAdapter myFragmentAdapter=new MyFragmentAdapter();

//
//        tabLayout=findViewById(R.id.tab);
//        viewPager2=findViewById(R.id.viewpager2);
//
//
//        tabLayout.addTab(tabLayout.newTab().setText("Medicine"));
//        tabLayout.addTab(tabLayout.newTab().setText("Appointment"));
//
//        FragmentManager fragmentManager= getSupportFragmentManager();
//        adapter=new MyFragmentAdapter(fragmentManager,getLifecycle());
//        viewPager2.setAdapter(adapter);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                Bundle bundle = getIntent().getExtras();
//                viewPager2.setCurrentItem(tab.getPosition());
//                bundle.putString("user_id", userid);
//
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                tabLayout.selectTab(tabLayout.getTabAt(position));
//            }
//        });



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