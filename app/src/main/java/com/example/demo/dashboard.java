package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.net.URISyntaxException;

public class dashboard extends AppCompatActivity {


    ImageView imageview1,imageView2,imageView3,imageView4;
    String user_dash_viewList="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Bundle bundle = getIntent().getExtras();



        imageview1=findViewById(R.id.setreminder);
        imageView2=findViewById(R.id.upcoming);
        imageView3=findViewById(R.id.viewlist);
        imageView4=findViewById(R.id.trackprogress);

        Intent frmLogin=getIntent();
        String userid=frmLogin.getStringExtra("user_id");

        Log.d("data_db","data= "+userid);






        //Log.d("data","data= "+getIntent().getExtras());
        //Log.d("data","data= "+bundle.getString("user_id"));
      imageview1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
//              user_dash_viewList=bundle.getString("user_id");
//              Bundle bundle_dash= new Bundle();
//              bundle_dash.putString("user_id", user_dash_viewList);

              Intent intent1=new Intent(getApplicationContext(),set_reminder.class);
              intent1.putExtras(frmLogin);
            //   intent1.putExtras(bundle_dash);
              startActivity(intent1);
              Log.d("data_imgviwe_sr","data= "+userid);

          }
      });

      imageView2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent2=new Intent(getApplicationContext(),MainActivity.class);
              intent2.putExtras(frmLogin);
              startActivity(intent2);
              Log.d("data_imgviwe_upcmg","data= "+userid);
          }
      });

      imageView3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
//              user_dash_viewList=bundle.getString("user_id");
//              Bundle bundle_dash= new Bundle();
//              bundle_dash.putString("user_id", user_dash_viewList);
              Intent intent3=new Intent(getApplicationContext(),viewList.class);
              intent3.putExtras(frmLogin);
//              intent3.putExtras(bundle_dash);
              startActivity(intent3);
              Log.d("data_imgview_vl","data= "+userid);
          }
      });

      imageView4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent4=new Intent(getApplicationContext(),MainActivity.class);
              startActivity(intent4);
              finish();
          }
      });




    }
}