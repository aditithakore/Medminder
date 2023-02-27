package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class upcomingapp extends AppCompatActivity {

    TextView date;
    private int year,month,day;
    RecyclerView recyclerView;
    String url = "https://ammoniac-initial.000webhostapp.com/getupapp.php";
    List<UpAppModelClass> imagelist;
    UpAppModelClass modelClass;
    LinearLayoutManager linearLayoutManager;
    UpAppadapter adapter;
    ProgressDialog mProgressDialog;
    String userid;
    String selecteddate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomingapp);

        Intent frmup = getIntent();
        userid = frmup.getStringExtra("user_id");
        Log.d("data_upApp", "data= " + userid);

        recyclerView = findViewById(R.id.rv_upapp);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        imagelist = new ArrayList<>();

        adapter = new UpAppadapter(this, imagelist);
        recyclerView.setAdapter(adapter);

        date=findViewById(R.id.tv_selectdate);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                year= calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(upcomingapp.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        date.setText(year+"/"+(month+1)+"/"+day);

                        selecteddate=date.getText().toString();
                        getApp(selecteddate);


                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }

    public String getApp(String date){

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                mProgressDialog.dismiss();

                imagelist.clear();
                try {
                    Log.i("tagconvertstr", "[" + response + "]");

                    JSONObject jsonObject = new JSONObject(response);
                    Log.i("tagconvertstr", "[" + response + "]");
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (success.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id=object.getString("id");
                            String docname = object.getString("docname");
                            String doccon = object.getString("docCon");
                            String date = object.getString("apTime");
                            String time = object.getString("apDate");
                            String user_id = object.getString("user_id");

                            modelClass = new UpAppModelClass(id,docname, doccon, date, time,user_id);
                            imagelist.add(modelClass);
                            adapter.notifyDataSetChanged();
                        }
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(upcomingapp.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("user_id",userid);
                map.put("apDate", date);
                //Log.d("");
                return map;
            }
        };

        mProgressDialog = new ProgressDialog(upcomingapp.this);
        mProgressDialog.setTitle("Please Wait!!");
        //mProgressDialog.setMax(100);
        mProgressDialog.setMessage("Fetching....");
        mProgressDialog.setProgressStyle(mProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();
        mProgressDialog.setCancelable(false);

        RequestQueue requestQueue = Volley.newRequestQueue(upcomingapp.this);
        requestQueue.add(request);

        return date;
    }



}
