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

public class appointment_List extends AppCompatActivity {

    RecyclerView recyclerView;
    String url = "https://ammoniac-initial.000webhostapp.com/getappointment.php";
    List<ModelClass> imagelist;
    ModelClass modelClass;
    LinearLayoutManager linearLayoutManager;
    vlAppointmentadapter adapter;
    ProgressDialog mProgressDialog;
    String userid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_list);
        Intent frmVl = getIntent();
        userid = frmVl.getStringExtra("user_id");
        Log.d("data_AppL", "data= " + userid);

        recyclerView = findViewById(R.id.rv_appList);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        imagelist = new ArrayList<>();

        adapter = new vlAppointmentadapter(this, imagelist);
        recyclerView.setAdapter(adapter);



        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                mProgressDialog.dismiss();

                imagelist.clear();
                try {


                    JSONObject jsonObject = new JSONObject(response);
                    Log.i("jsonobj", "["+response+"]");
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

                            modelClass = new ModelClass(id,docname, doccon, date, time,user_id);
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
                Toast.makeText(appointment_List.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                map.put("user_id",userid);
                return map;
            }
        };

        mProgressDialog = new ProgressDialog(appointment_List.this);
        mProgressDialog.setTitle("Please Wait!!");
        //mProgressDialog.setMax(100);
        mProgressDialog.setMessage("Fetching....");
        mProgressDialog.setProgressStyle(mProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();
        mProgressDialog.setCancelable(false);

        RequestQueue requestQueue = Volley.newRequestQueue(appointment_List.this);
        requestQueue.add(request);
            }
        }