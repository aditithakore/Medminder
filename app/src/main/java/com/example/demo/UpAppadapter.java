package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UpAppadapter extends RecyclerView.Adapter<ImageViewHolderUpcomingAppointment> {
    private Context context;
    private List<UpAppModelClass> imagelist;

    public UpAppadapter(Context context, List<UpAppModelClass> imagelist){
        this.context=context;
        this.imagelist=imagelist;
    }

    @NonNull
    @Override
    public ImageViewHolderUpcomingAppointment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.upappointmentcard, parent,false);
        return new ImageViewHolderUpcomingAppointment(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolderUpcomingAppointment holder, int position) {

        final UpAppModelClass temp = imagelist.get(position);

        holder.docname.setText(temp.getDocname());
        holder.doccon.setText(temp.getDoccon());
        holder.time.setText(temp.getTime());
        holder.date.setText(temp.getDate());
    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }
}

class ImageViewHolderUpcomingAppointment extends RecyclerView.ViewHolder {

    TextView docname, doccon, time, date;
    ImageView cal;

    public ImageViewHolderUpcomingAppointment(@NonNull View itemView) {
        super(itemView);
        docname=itemView.findViewById(R.id.rv_updocname);
        doccon=itemView.findViewById(R.id.rv_updoccon);
        time=itemView.findViewById(R.id.rvupapptime);
        date=itemView.findViewById(R.id.rvupappdate);
        cal=itemView.findViewById(R.id.upimaeCal);

    }
}
