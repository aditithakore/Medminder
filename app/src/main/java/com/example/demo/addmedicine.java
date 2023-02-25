//package com.example.demo;
//
//import static android.content.Intent.getIntent;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class addmedicine extends Fragment {
//
//
//
//ImageView imgview;
//
//
//
//   @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//
//
//
////        List<String> data = new ArrayList<>();
////        data.add("user_id");
////        args.putStringArrayList("user_id",);
////        fragment.setArguments(args);
//
//
//   //     View rootview= inflater.inflate(R.layout.fragment_addmedicine,container,false);
//
////        Bundle preBundle = getArguments();
////        String userid=preBundle.getString("user_id");
////
////        Log.d("data_addMed","data= " +userid);
//       // String userid=getArguments().getString("user_id");
////        imgview=(ImageView)rootview.findViewById(R.id.add_bt1);
////        imgview.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
// //               String userid=getArguments().getString("user_id");
////                Intent frmSr=getIntent();
////                String userid=frmSr.getStringExtra("user_id");
//          //      Intent intent= new Intent(getActivity().getApplicationContext(),medicine.class);
////                intent.putExtra("user_id",userid);
//
////                startActivity(intent);
////            }
////        });
////        return rootview;
//return inflater.inflate(R.layout.fragment_appointment, container, false);
//    //}
//}}