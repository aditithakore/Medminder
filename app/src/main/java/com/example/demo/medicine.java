package com.example.demo;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class medicine extends AppCompatActivity {

    private int year,month,day;
    ImageView save;
    int i =1;
   EditText timeselect,medname;
   Button addButton,dose1,dose2,dose3, dose4,dose5;
    TextView startDate,endDate;
    CheckBox monday,tuesday,wednesday,thursday,friday,saturday,sunday,everyday;
    static boolean mon=false,tue=false,wed=false,thurs=false,fri=false,sat=false,sun=false;
    EditText med1,med2,med3,med4,med5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);


        Date currentDate=new Date();
        Log.d("current date","date is= "+currentDate.toString());

        SimpleDateFormat datestr=new SimpleDateFormat("dd");
        String days=(String)(datestr.format(currentDate));

        Log.d("day is ","day is= "+days);

        Intent frmSr=getIntent();
        String userid=frmSr.getStringExtra("user_id");
        Log.d("data_addMed","Data= "+userid);
        timeselect=findViewById(R.id.medicine_time0);
        dose1=findViewById(R.id.dose1);
        dose2=findViewById(R.id.dose2);
        dose3=findViewById(R.id.dose3);
        dose4=findViewById(R.id.dose4);
        dose5=findViewById(R.id.dose5);
        med1=findViewById(R.id.medicine_time0);
        med2=findViewById(R.id.medicine_time1);
        med3=findViewById(R.id.medicine_time2);
        med4=findViewById(R.id.medicine_time3);
        med5=findViewById(R.id.medicine_time4);
        medname=findViewById(R.id.edit_med_name);
        CardView cardView= findViewById(R.id.medicinecard0);
        CardView cardView1= findViewById(R.id.medicinecard1);
        CardView cardView2= findViewById(R.id.medicinecard2);
        CardView cardView3= findViewById(R.id.medicinecard3);
        CardView cardView4= findViewById(R.id.medicinecard4);

        dose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.VISIBLE);
                cardView1.setVisibility(View.INVISIBLE);
                cardView2.setVisibility(View.INVISIBLE);
                cardView3.setVisibility(View.INVISIBLE);
                cardView4.setVisibility(View.INVISIBLE);
            }
        });
        dose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.VISIBLE);
                cardView1.setVisibility(View.VISIBLE);
                cardView2.setVisibility(View.INVISIBLE);
                cardView3.setVisibility(View.INVISIBLE);
                cardView4.setVisibility(View.INVISIBLE);
            }
        });
        dose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.VISIBLE);
                cardView1.setVisibility(View.VISIBLE);
                cardView2.setVisibility(View.VISIBLE);
                cardView3.setVisibility(View.INVISIBLE);
                cardView4.setVisibility(View.INVISIBLE);
            }
        });
        dose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.VISIBLE);
                cardView1.setVisibility(View.VISIBLE);
                cardView2.setVisibility(View.VISIBLE);
                cardView3.setVisibility(View.VISIBLE);
                cardView4.setVisibility(View.INVISIBLE);
            }
        });
        dose5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.VISIBLE);
                cardView1.setVisibility(View.VISIBLE);
                cardView2.setVisibility(View.VISIBLE);
                cardView3.setVisibility(View.VISIBLE);
                cardView4.setVisibility(View.VISIBLE);
            }
        });

        save=findViewById(R.id.imageViewSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String med_name, start_date, end_date, user_id = null;
                med_name = String.valueOf(medname.getText());
                start_date = String.valueOf(startDate.getText());
                end_date = String.valueOf(endDate.getText());

                //this is for time
                ArrayList<String> time = new ArrayList<String>();

                if(!med1.getText().toString().isEmpty()){
                    time.add(med1.getText().toString());
                }
                if(!med2.getText().toString().isEmpty()){
                    time.add(med2.getText().toString());
                }
                if(!med3.getText().toString().isEmpty()){
                    time.add(med3.getText().toString());
                }
                if(!med4.getText().toString().isEmpty()){
                    time.add(med4.getText().toString());
                }
                if(!med5.getText().toString().isEmpty()){
                    time.add(med5.getText().toString());
                }

                Toast.makeText(getApplicationContext(), "time : " + TextUtils.join(",", time), Toast.LENGTH_SHORT).show();


                //this is for days
                ArrayList<String> days = new ArrayList<String>();
                if (mon == true) {
                    days.add("monday");
                }
                if (tue == true) {
                    days.add("tuesday");
                }
                if (wed == true) {
                    days.add("wednesday");
                }
                if (thurs == true) {
                    days.add("thursday");
                }
                if (fri == true) {
                    days.add("friday");
                }
                if (sat == true) {
                    days.add("saturday");
                }
                if (sun == true) {
                    days.add("sunday");
                }
                Toast.makeText(getApplicationContext(), "days selected: " + TextUtils.join(",", days), Toast.LENGTH_SHORT).show();
                String[] field = new String[6];
                field[0] = "med_name";
                field[1] = "start_date";
                field[2] = "end_date";
                field[3] = "days";
                field[4] = "time";
                field[5] = "user_id";

                //Creating array for data
                String[] data = new String[6];
                data[0] = med_name;
                data[1] = start_date;
                data[2] = end_date;
                data[3] = TextUtils.join(",", days);
                data[4] = TextUtils.join(",", time);
                data[5] = getIntent().getStringExtra("user_id");

                PutData putData = new PutData("https://ammoniac-initial.000webhostapp.com/addmedicine.php", "POST", field, data);
                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        String result = putData.getResult();
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                           setAlarm(med_name, TextUtils.join(",", days),TextUtils.join(",", time));


                        Log.d("data_medicine", "data= " + result);
                        Intent intent = new Intent(getApplicationContext(), set_reminder.class);
                        intent.putExtras(frmSr);
                        startActivity(intent);
                        Log.d("data_medtosr","data= "+userid);
                    }
                }
                days.clear();
            }
        });


        monday=findViewById(R.id.monday);
        tuesday=findViewById(R.id.tuesday);
        wednesday=findViewById(R.id.wed);
        thursday=findViewById(R.id.thurs);
            friday=findViewById(R.id.fri);
            saturday=findViewById(R.id.sat);
            sunday=findViewById(R.id.sunday);
            everyday=findViewById(R.id.every_day);

            everyday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mon=tue=wed=thurs=fri=sat=sun=true;
                        monday.setChecked(true);
                        tuesday.setChecked(true);
                        wednesday.setChecked(true);
                            thursday.setChecked(true);
                            friday.setChecked(true);
                            saturday.setChecked(true);
                            sunday.setChecked(true);
                    }
                    else
                    {
                        mon=tue=wed=thurs=fri=sat=sun=false;
                        monday.setChecked(false);
                        tuesday.setChecked(false);
                        wednesday.setChecked(false);
                        thursday.setChecked(false);
                        friday.setChecked(false);
                        saturday.setChecked(false);
                        sunday.setChecked(false);
                    }
                }
            });


            monday.setOnCheckedChangeListener(
                    new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked){
                                mon=true;
                                Toast.makeText(medicine.this, "Monday selected", Toast.LENGTH_SHORT).show();
                                monday.setBackgroundColor(Color.parseColor("#72D6FF"));
                            }
                            else
                            {
                             mon=false;
//                             Toast.makeText(medicine.this, "Monday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                                monday.setBackgroundColor(Color.parseColor("#FFFFFF"));
                            }
                        }
                    }
            );
        tuesday.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            tue=true;
                            Toast.makeText(medicine.this, "Tuesday selected ", Toast.LENGTH_SHORT).show();
                            tuesday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            tue=false;
                        //      Toast.makeText(medicine.this, "Tuesday checked status  "+isChecked+" "+tue, Toast.LENGTH_SHORT).show();
                            tuesday.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                    }
                }
        );
       wednesday.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            wed=true;
                            Toast.makeText(medicine.this, "Wednesday selcted", Toast.LENGTH_SHORT).show();
                            wednesday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            wed=false;
//                            Toast.makeText(medicine.this, "Wednesday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            wednesday.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                    }
                }
        );

        thursday.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            thurs=true;
                            Toast.makeText(medicine.this, "Thursday selected", Toast.LENGTH_SHORT).show();
                            thursday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            thurs=false;
                        //    Toast.makeText(medicine.this, "Thursday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            thursday.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                    }
                }
        );
        friday.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            fri=true;
                            Toast.makeText(medicine.this, "Friday selected ", Toast.LENGTH_SHORT).show();
                            friday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            fri=false;
                          //  Toast.makeText(medicine.this, "Friday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            friday.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                    }
                }
        );

        saturday.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            sat=true;
                            Toast.makeText(medicine.this, "Saturday selected", Toast.LENGTH_SHORT).show();
                            saturday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            sat=false;
                      //      Toast.makeText(medicine.this, "Saturday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            saturday.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                    }
                }
        );

        sunday.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            sun=true;
                            Toast.makeText(medicine.this, "Sunday selected ", Toast.LENGTH_SHORT).show();
                            sunday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            sun=false;
                           // Toast.makeText(medicine.this, "Sunday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            sunday.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                    }
                }
        );

        startDate=findViewById(R.id.startdate);
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                year= calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(medicine.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        startDate.setText(year+"/"+(month+1)+"/"+day);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


        endDate=findViewById(R.id.enddate);
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                year= calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(medicine.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        endDate.setText(year+"/"+(month+1)+"/"+day);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }

    private  void setAlarm(String medname, String  days, String time){
        AlarmManager am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);

        Intent intent= new Intent(getApplicationContext(),AppBroadcastRec.class);
        intent.putExtra("medname",medname);
        intent.putExtra("date",days);
        intent.putExtra("time",time);

        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
        String dateandtime= days+" "+time;
        DateFormat format= new SimpleDateFormat("yyyy/MM/dd hh:mm");
        try {
            Log.d("datee ", "date= "+dateandtime);
            Date date1 = format.parse(dateandtime);
            Log.d("datee ", "date1= "+date1.getTime());
            am.set(AlarmManager.RTC_WAKEUP, date1.getTime(), pendingIntent);
            Toast.makeText(getApplicationContext(), "Alaram", Toast.LENGTH_SHORT).show();

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


    public void methodOnClick(@NonNull View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
        }
    }
}
