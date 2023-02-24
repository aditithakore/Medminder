package com.example.demo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.ArrayList;

public class AppointmentList extends Fragment {
//NO USEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE










//    RecyclerView recyclerView;
//    private ArrayList<AppointmentListRV> appointmentArrayList;
//    //OkHttpClient client = new OkHttpClient();
//    public String userId= "";
//
//
//
//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
////        if (getArguments() != null) {
////            userId = getArguments().getString("user_id");
////        }
//
//
//
//
//
////        Log.d("get user id frm VL_Act","data= "+userId);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        Bundle bundle = getArguments();
//        if (bundle!= null) {
//            userId = bundle.getString("user_id");
//        }
//        Log.d("get user id frm VL_Act","data= "+userId);
//
//
////        Log.d("data","data= "+getIntent().getExtras());
////        Log.d("data","data= "+bundle.getString("user_id"));
//
//        View rootview= inflater.inflate(R.layout.fragment_appointment_list,container,false);
//        recyclerView=(RecyclerView) rootview.findViewById(R.id.recyclerAppointment);
//
//        String[] field = new String[1];
//        field[0] = "user_id";
//
//
//        //Creating array for data
//        String[] data = new String[1];
//        data[0] = userId;
//
//        //System.out.println(data[0]);
//
//        Log.d("data","data= "+data[0]);
//
//        PutData putData = new PutData("https://ammoniac-initial.000webhostapp.com/login.php","POST", field, data);
//        if (putData.startPut()) {
//            if (putData.onComplete()) {}}

        // Inflate the layout for this fragment
     //   return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
//        dataInitialized();
    }

//    private void dataInitialized() {
//
//
//        appointmentArrayList= new ArrayList<>();

        //check how to take input string frm user in appointment tab when you take doc name and show uska id here after hardcoding it in strings.xml


//        doctorName=new String[]{
//                getString(R.string.head_1),
//                getString(R.string.docname_2),
//                getString(R.string.docname_3),
//                getString(R.string.docname_4),
//                getString(R.string.docname_5),
//                getString(R.string.docname_6),
//                getString(R.string.docname_7),
//                getString(R.string.docname_8),
//                getString(R.string.docname_9)}

        }
    //}
