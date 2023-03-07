package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class medicineCardList extends AppCompatActivity {

    RecyclerView recyclerView;
    String url = "https://ammoniac-initial.000webhostapp.com/getmedicine.php";
    List<MedModelClass> imagelistmed;
    MedModelClass medmodelClass;
    LinearLayoutManager linearLayoutManager;
    vlMedicineadapter adapter;
    ProgressDialog mProgressDialog;
    String userid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_card_list);
        Intent frmVl = getIntent();
        userid = frmVl.getStringExtra("user_id");
        Log.d("data_MedL", "data= " + userid);

        recyclerView = findViewById(R.id.rv_medList);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        imagelistmed = new ArrayList<>();

        adapter = new vlMedicineadapter(this, imagelistmed);
        recyclerView.setAdapter(adapter);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                mProgressDialog.dismiss();

                imagelistmed.clear();
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    Log.d("jsonobj", "["+response+"]");
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (success.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);

                            String id=object.getString("id");
                            String medname = object.getString("med_name");
                            String startdate = object.getString("start_date");
                            String enddate = object.getString("end_date");
                            String days = object.getString("meddays");
                            String time = object.getString("time");
                            String user_id = object.getString("userid");

                            medmodelClass = new MedModelClass(id,medname,startdate,enddate,days,time,user_id);
                            imagelistmed.add(medmodelClass);
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
                Toast.makeText(medicineCardList.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("userid",userid);
                return map;
            }
        };

        mProgressDialog = new ProgressDialog(medicineCardList.this);
        mProgressDialog.setTitle("Please Wait!");
        mProgressDialog.setMessage("Fetching...");
        mProgressDialog.setProgressStyle(mProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();
        mProgressDialog.setCancelable(false);

        RequestQueue requestQueue = Volley.newRequestQueue(medicineCardList.this);
        requestQueue.add(request);


    }
}