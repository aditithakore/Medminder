package com.example.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class AppointmentFragment extends Fragment {

    ImageView imageview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview= inflater.inflate(R.layout.fragment_appointment,container,false);
        imageview=(ImageView)rootview.findViewById(R.id.add_btapp);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity().getApplicationContext(),appointment.class);
                try {
                    startActivity(intent);
                }
                catch (NullPointerException e){


                }

            }
        });
        return rootview;
        //return inflater.inflate(R.layout.fragment_appointment, container, false);
    }
}