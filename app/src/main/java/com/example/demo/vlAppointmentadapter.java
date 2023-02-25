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

import com.example.demo.R;

import java.util.List;

public class vlAppointmentadapter extends RecyclerView.Adapter<ImageViewHolderViewData>{
    private Context context;
    private List<ModelClass> imagelist;
    public vlAppointmentadapter(Context context, List<ModelClass> imagelist){
        this.context=context;
        this.imagelist=imagelist;
    }

    @NonNull
    @Override
    public ImageViewHolderViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.appointmentcard, parent,false);
        return new ImageViewHolderViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolderViewData holder, int position) {

        final ModelClass temp = imagelist.get(position);

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


class ImageViewHolderViewData extends RecyclerView.ViewHolder {

    TextView docname, doccon, time, date;
    ImageView cal, edit, delete;
    RelativeLayout rv_relativeLayout;

    public ImageViewHolderViewData(@NonNull View itemView) {
        super(itemView);
        docname=itemView.findViewById(R.id.rv_docname);
        doccon=itemView.findViewById(R.id.rv_doccon);
        time=itemView.findViewById(R.id.rvapptime);
        date=itemView.findViewById(R.id.rvappdate);
        cal=itemView.findViewById(R.id.imaeCal);
        edit=itemView.findViewById(R.id.edit);
        delete=itemView.findViewById(R.id.remove);




    }
}