package com.example.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class addmedicine extends Fragment {



ImageView imgview;



   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview= inflater.inflate(R.layout.fragment_addmedicine,container,false);
        imgview=(ImageView)rootview.findViewById(R.id.add_bt1);
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity().getApplicationContext(),medicine.class);
                startActivity(intent);
            }
        });
        return rootview;
        //return inflater.inflate(R.layout.fragment_appointment, container, false);
    }
}