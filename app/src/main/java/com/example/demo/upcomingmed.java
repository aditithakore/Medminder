package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class upcomingmed extends AppCompatActivity {

    Spinner spinner;
    String selectedday;
    RecyclerView rvupmed;
    String url = "https://ammoniac-initial.000webhostapp.com/getupmed.php";
    List<UpMedModelClass> imagelist;
    UpMedModelClass modelClass;
    LinearLayoutManager linearLayoutManager;
    UpMedadapter adapter;
    ProgressDialog mProgressDialog;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomingmed);
        Intent frmup = getIntent();
        userid = frmup.getStringExtra("user_id");
        Log.d("data_upMed", "data= " + userid);


        rvupmed = findViewById(R.id.rv_upmed);
        linearLayoutManager = new LinearLayoutManager(this);
        rvupmed.setLayoutManager(linearLayoutManager);
        imagelist = new ArrayList<>();
        adapter = new UpMedadapter(this, imagelist);
        rvupmed.setAdapter(adapter);

        spinner = findViewById(R.id.days);

        String[] days = getResources().getStringArray(R.array.days);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, days);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              selectedday=adapterView.getItemAtPosition(i).toString();

              getupmed(selectedday);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }


    public String getupmed(String dayselected) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                mProgressDialog.dismiss();

                imagelist.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.i("JSONobj", "[" + response + "]");
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (success.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String medname = object.getString("med_name");
                            String startdate = object.getString("start_date");
                            String enddate = object.getString("end_date");
                            String days = object.getString("meddays");
                            String time = object.getString("time");
                            String user_id = object.getString("userid");

                            modelClass = new UpMedModelClass(id, medname, startdate, enddate, days, time, user_id);
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
                Toast.makeText(upcomingmed.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("userid", userid);
                map.put("meddays", dayselected);
                //Log.d("");
                return map;
            }
        };

        mProgressDialog = new ProgressDialog(upcomingmed.this);
        mProgressDialog.setTitle("Please Wait!!");
        //mProgressDialog.setMax(100);
        mProgressDialog.setMessage("Fetching....");
        mProgressDialog.setProgressStyle(mProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();
        mProgressDialog.setCancelable(false);

        RequestQueue requestQueue = Volley.newRequestQueue(upcomingmed.this);
        requestQueue.add(request);

        return dayselected;
    }
}