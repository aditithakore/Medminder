package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//public class appointmentRecyclerviewAdapter extends RecyclerView.Adapter<appointmentRecyclerviewAdapter.Viewholder> {
//NO USE ABHIIIIIIIIIIIIIIII










//    Context context;
//    ArrayList<AppointmentListRV> appointmentsArrayList;
//
//    public appointmentRecyclerviewAdapter(Context context, ArrayList<AppointmentListRV> appointmentsArrayList) {
//
//        this.context= context;
//        this.appointmentsArrayList=appointmentsArrayList;
//    }
//
//    @NonNull
//    @Override
//    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View v= LayoutInflater.from(context).inflate(R.layout.appointmentlistitem,parent,false);
//        return new Viewholder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
//
//        AppointmentListRV appointmentList= appointmentsArrayList.get(position);
//        holder.txtv1.setText(appointmentList.doctorName);
//        holder.textv2.setText(appointmentList.doctorContact);
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return appointmentsArrayList.size();
//    }
//
//    public static class Viewholder extends RecyclerView.ViewHolder{
//
//        ImageView imageView;
//        TextView txtv1,textv2;
//
//
//
//        public Viewholder(@NonNull View itemView) {
//
//            super(itemView);
//            imageView=itemView.findViewById(R.id.appcal);
//            txtv1=itemView.findViewById(R.id.rv_docName);
//            textv2=itemView.findViewById(R.id.rv_doccon);
//
//
//        }
//    }
//}
