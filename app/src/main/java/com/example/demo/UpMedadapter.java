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

public class UpMedadapter extends RecyclerView.Adapter<ImageViewHolderUpcomingMedicine>{
    private Context context;
    private List<UpMedModelClass> imagelist;

    public UpMedadapter(Context context, List<UpMedModelClass> imagelist){
        this.context=context;
        this.imagelist=imagelist;
    }

    @NonNull
    @Override
    public ImageViewHolderUpcomingMedicine onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.upmedcard,parent,false);
        return new ImageViewHolderUpcomingMedicine(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolderUpcomingMedicine holder, int position) {

        final UpMedModelClass temp = imagelist.get(position);

        holder.medname.setText(temp.getMedName());
        holder.medtime.setText(temp.getTimeMed());

    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }
}

class ImageViewHolderUpcomingMedicine extends RecyclerView.ViewHolder {

    TextView medname, medtime;
    ImageView pill;


    public ImageViewHolderUpcomingMedicine(@NonNull View itemView) {
        super(itemView);
        medname=itemView.findViewById(R.id.rv_upmedname);
        medtime=itemView.findViewById(R.id.rvupmedtime);
        pill=itemView.findViewById(R.id.upimaepill);


    }
}
