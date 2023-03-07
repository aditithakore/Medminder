package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo.R;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class vlAppointmentadapter extends RecyclerView.Adapter<ImageViewHolderViewData>{
    private Context context;
    private List<ModelClass> imagelist;
    String update_url="https://ammoniac-initial.000webhostapp.com/updateapp.php";
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

        holder.appid.setText(temp.getId());
        holder.docname.setText(temp.getDocname());
        holder.doccon.setText(temp.getDoccon());
        holder.time.setText(temp.getTime());
        holder.date.setText(temp.getDate());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus= DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.editapp))
                        .setExpanded(true,1400).create();


                View myview = dialogPlus.getHolderView();
                final EditText docname = myview.findViewById(R.id.edit_doc_name);
                final EditText doccon = myview.findViewById(R.id.edit_doc_con);
                final TextView time = myview.findViewById(R.id.edit_appoinment_time);
                final TextView date=myview.findViewById(R.id.edit_date);
                final TextView appid = (TextView) myview.findViewById(R.id.appid);
                 Button save=myview.findViewById(R.id.updateapp);


               appid.setText(temp.getId().toString());
                docname.setText(temp.getDocname());
                doccon.setText(temp.getDoccon());
                time.setText(temp.getTime());
                date.setText(temp.getDate());

                dialogPlus.show();
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StringRequest request = new StringRequest(Request.Method.POST, update_url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                if (response.equals("Record updated successfully!!")) {
                                    Toast.makeText(context.getApplicationContext(), "Record updated successfully!!", Toast.LENGTH_LONG).show();
                                    dialogPlus.dismiss();
                                    Intent intent=new Intent(context,MainActivity.class);
                                    context.startActivity(intent);

                                } else {
                                    Toast.makeText(context.getApplicationContext(), "Update Failed" + response.toString(), Toast.LENGTH_LONG).show();
                                    dialogPlus.dismiss();
                                    Intent intent=new Intent(context,MainActivity.class);
                                    context.startActivity(intent);

                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(context.getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                                dialogPlus.dismiss();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> map = new HashMap<String, String>();
                                map.put("apid",appid.getText().toString());
                                map.put("docname", docname.getText().toString());
                                map.put("docCon", doccon.getText().toString());
                                map.put("apTime", time.getText().toString());
                                map.put("apDate", date.getText().toString());

                                return map;
                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(context);
                        requestQueue.add(request);
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }
}


class ImageViewHolderViewData extends RecyclerView.ViewHolder {

    TextView docname, doccon, time, date,appid;
    ImageView cal, edit, delete;
    RelativeLayout rv_relativeLayout;

    public ImageViewHolderViewData(@NonNull View itemView) {
        super(itemView);
        appid=itemView.findViewById(R.id.appid);
        docname=itemView.findViewById(R.id.rv_docname);
        doccon=itemView.findViewById(R.id.rv_doccon);
        time=itemView.findViewById(R.id.rvapptime);
        date=itemView.findViewById(R.id.rvappdate);
        cal=itemView.findViewById(R.id.imaeCal);
        edit=itemView.findViewById(R.id.edit);
        delete=itemView.findViewById(R.id.remove);




    }
}