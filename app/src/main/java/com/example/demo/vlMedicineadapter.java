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

public class vlMedicineadapter extends RecyclerView.Adapter<ImageViewHolderViewMedicine>{
    private Context context;
    private List<MedModelClass> imagelist;
    public vlMedicineadapter(Context context, List<MedModelClass> imagelist){
        this.context=context;
        this.imagelist=imagelist;
    }


    @NonNull
    @Override
    public ImageViewHolderViewMedicine onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinecard,parent,false);
        return new ImageViewHolderViewMedicine(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolderViewMedicine holder, int position) {

        final MedModelClass temp = imagelist.get(position);


    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }
}


class ImageViewHolderViewMedicine extends RecyclerView.ViewHolder {

    TextView medname, medtime;
    ImageView pill, editmed, deletemed;
    RelativeLayout rv_relativeLayout;

    public ImageViewHolderViewMedicine(@NonNull View itemView) {
        super(itemView);
        medname=itemView.findViewById(R.id.rv_medname);
        medtime=itemView.findViewById(R.id.rvmedtime);
        pill=itemView.findViewById(R.id.imaepill);
        editmed=itemView.findViewById(R.id.editmed);
        deletemed=itemView.findViewById(R.id.removemed);




    }
}
