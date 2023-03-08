package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orhanobut.dialogplus.DialogPlus;

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

        holder.medname.setText(temp.getMedName());
        holder.medtime.setText(temp.getTimeMed());

        holder.editmed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus= DialogPlus.newDialog(view.getContext())
                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.editapp))
                        .setExpanded(true,1400).create();


                View myview = dialogPlus.getHolderView();
                final EditText medname = myview.findViewById(R.id.edit_doc_name);
                final EditText doccon = myview.findViewById(R.id.edit_doc_con);
                final TextView time = myview.findViewById(R.id.edit_appoinment_time);
                final TextView date=myview.findViewById(R.id.edit_date);
                final TextView appid = (TextView) myview.findViewById(R.id.appid);
                Button save=myview.findViewById(R.id.updateapp);
            }
        });



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
