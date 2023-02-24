import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.ModelClass;
import com.example.demo.R;


import java.util.List;

public class vlAppointmentadapter extends RecyclerView.Adapter<vlAppointmentadapter>{
    private Context context;

    private List<ModelClass> imagelist;
    ModelClass modelClass;
    public vlAppointmentadapter(Context context, List<ModelClass> imagelist) {
        this.context = context;
        this.imagelist = imagelist;
    }


    @NonNull
    @Override
    public vlAppointmentadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.);
        return new ImageViewHolderViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vlAppointmentadapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}


class ImageViewHolderViewData extends RecyclerView.ViewHolder {

    TextView docname, doccon, time, date;
    ImageView bkPic, edit, delete;
    RelativeLayout rv_relativeLayout;

    public ImageViewHolderViewData(@NonNull View itemView) {
        super(itemView);

        docname = itemView.findViewById(R.id.rv_docName);
        doccon = itemView.findViewById(R.id.rv_doccon);
        time = itemView.findViewById(R.id.);
        date = itemView.findViewById(R.id.rv_appDate);



    }
}