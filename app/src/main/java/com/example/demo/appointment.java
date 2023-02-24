package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

public class appointment extends AppCompatActivity {

    private int hour, minute;
    private int year,month,day;
//    private OkHttpClient client;
//    private Response response;
//    private RequestBody requestBody;
//    private String strJson,apiUrl="";
//    private Request request;

    EditText docname,docCon;
    TextView timeselect,date;
    ImageView imageView,canbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        Log.d("data_addAppointment","Data= "+getIntent().getStringExtra("user_id"));

        docname=findViewById(R.id.doc_name);
        docCon=findViewById(R.id.doc_con);

        timeselect= findViewById(R.id.appoinment_time);
      //to underline the textview
        timeselect.setPaintFlags(timeselect.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        date=findViewById(R.id.date);
        //to underline the texview
        date.setPaintFlags(date.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);




        imageView=findViewById(R.id.save);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String drname, drCon,apTime,apDate,user_id = null;
                 drname = String.valueOf(docname.getText());
                drCon = String.valueOf(docCon.getText());
                apTime= String.valueOf(timeselect.getText());
                apDate= String.valueOf(date.getText());

                if (!drname.equals("") && !drCon.equals("") && !apTime.equals("") && !apDate.equals("")) {


                  //  progress.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[5];
                            field[0] = "drname";
                            field[1] = "drCon";
                            field[2] ="apTime";
                            field[3] = "apDate";
                            field[4]="user_id";

                            //Creating array for data
                            String[] data = new String[5];
                            data[0] = drname;
                            data[1] = drCon;
                            data[2] =apTime;
                            data[3] = apDate;
                            data[4]=getIntent().getStringExtra("user_id");

                            PutData putData = new PutData("https://ammoniac-initial.000webhostapp.com/addappointment.php","POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Appointment added Sucessfully")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), dashboard.class);
                                        startActivity(intent);
                                        finish();
                                    }

                                    else{

                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
//                else{
//                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
//                }
            //}
       // });

    }
        });


        timeselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {showTimePicker();}
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                year= calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(appointment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        date.setText(year+"/"+(month+1)+"/"+day);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
}


    private void showTimePicker() {
        Calendar mCurrentTime = Calendar.getInstance();
        hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
        minute = mCurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(appointment.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeselect.setText(String.format(Locale.getDefault(), "%d:%d", selectedHour, selectedMinute));
            }
        }, hour, minute, false);
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

//    public class GetUserDataRequest extends AsyncTask<Void,Void,Void>{
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            //requestBody= new FormEncodingBuilder().build();
//            request= new Request.Builder().url(apiUrl).build();
//
//            try{
//                response=client.newCall(request).execute();
//                            }
//            catch(IOException e){
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void unused){
//            super.onPostExecute(unused);
//
//            try {
//                strJson=response.body().string();
//                updateUserData(strJson);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    private void updateUserData(String strJson){
//     //   Glide.with(this).load(drname).into()
//    }


}