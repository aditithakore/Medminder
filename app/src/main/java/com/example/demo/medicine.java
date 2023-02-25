package com.example.demo;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class medicine extends AppCompatActivity {


    private LinearLayout parentLinearLayout;
    private int hour, minute;
    private int year,month,day;
    ImageView save;
    private View rootView;
    int i =1;
   EditText timeselect,medname;
   TextView layoutTimeSelect;
   Button addButton,dose1,dose2,dose3, dose4,dose5;
    TextView startDate,endDate;
    Calendar calendar=Calendar.getInstance();
    CheckBox monday,tuesday,wednesday,thursday,friday,saturday,sunday,everyday;
    static boolean mon=false,tue=false,wed=false,thurs=false,fri=false,sat=false,sun=false;


    EditText med1,med2,med3,med4,med5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);


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



//        ArrayAdapter   arrayAdapter = new ArrayAdapter(medicine.this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, Collections.singletonList(dosage));

//        dosespinner.setAdapter(arrayAdapter);
//        dosespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
//               int position=pos;
//
//            switch (position){
//                case 0:
//                    break;
//                case 1:
//                    cardView.setVisibility(View.VISIBLE);
//                    break;
//                case 2:
//                    cardView.setVisibility(View.VISIBLE);
//                    cardView1.setVisibility(View.VISIBLE);
//                    break;
//                case 3:
//                    cardView.setVisibility(View.VISIBLE);
//                    cardView1.setVisibility(View.VISIBLE);
//                    cardView2.setVisibility(View.VISIBLE);
//                    break;
//                case 4:
//                    cardView.setVisibility(View.VISIBLE);
//                    cardView1.setVisibility(View.VISIBLE);
//                    cardView2.setVisibility(View.VISIBLE);
//                    cardView3.setVisibility(View.VISIBLE);
//                    break;
//                case 5:
//                    cardView.setVisibility(View.VISIBLE);
//                    cardView1.setVisibility(View.VISIBLE);
//                    cardView2.setVisibility(View.VISIBLE);
//                    cardView3.setVisibility(View.VISIBLE);
//                    cardView4.setVisibility(View.VISIBLE);
//                    break;
//            }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

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
                //String[] days=new String[7];
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

               // String[] Days = (String[]) days.toArray();

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
                        Log.d("data_medicine", "data= " + result);
                        Intent intent = new Intent(getApplicationContext(), set_reminder.class);
//                        Intent frmdb=getIntent();
//                        String userid=frmdb.getStringExtra("user_id");
//                        Log.d("data_sr-db","data= "+userid);
                        intent.putExtras(frmSr);
//                        intent.putExtras(bundle);
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
                                Toast.makeText(medicine.this, "Monday checked status "+isChecked+" "+mon+" "+tue, Toast.LENGTH_SHORT).show();
                                monday.setBackgroundColor(Color.parseColor("#72D6FF"));

                            }
                            else
                            {
                             mon=false;
                             Toast.makeText(medicine.this, "Monday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(medicine.this, "Tuesday checked status "+isChecked+" "+tue, Toast.LENGTH_SHORT).show();
                            tuesday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            tue=false;
                            Toast.makeText(medicine.this, "Tuesday checked status  "+isChecked+" "+tue, Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(medicine.this, "Wednesday checked status "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            wednesday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            wed=false;
                            Toast.makeText(medicine.this, "Wednesday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(medicine.this, "Thursday checked status "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            thursday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            thurs=false;
                            Toast.makeText(medicine.this, "Thursday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(medicine.this, "Friday checked status "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            friday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            fri=false;
                            Toast.makeText(medicine.this, "Friday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(medicine.this, "Saturday checked status "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            saturday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            sat=false;
                            Toast.makeText(medicine.this, "Saturday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(medicine.this, "Sunday checked status "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            sunday.setBackgroundColor(Color.parseColor("#72D6FF"));
                        }
                        else
                        {
                            sun=false;
                            Toast.makeText(medicine.this, "Sunday checked status  "+isChecked+" "+mon, Toast.LENGTH_SHORT).show();
                            sunday.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                    }
                }
        );



        //parentLinearLayout=(LinearLayout) findViewById(R.id.containerLayout);
//addButton=findViewById(R.id.add_field_button);
//addButton.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        final View rowView=inflater.inflate(R.layout.medcard_view_layout, null);
//
//        rowView.findViewById(R.id.medicine_time).setId(R.id.medicine_time+i);
//        Toast.makeText(getApplicationContext(),"tost of i "+ i,Toast.LENGTH_SHORT).show();
//
//
//        // Add the new row before the add field button.
//        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
//
//        Toast.makeText(getApplicationContext(),"" +findViewById(R.id.medicine_time).getId(),Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(),"" +findViewById(R.id.medicine_time+i).getId(),Toast.LENGTH_SHORT).show();
//
//        i=i+1;
//}});





//        NumberPicker numberPicker = findViewById(R.id.tv_dose_quantity);
//        numberPicker.setMinValue(0);
//        numberPicker.setMaxValue(10);
//         CardView cardView0 = findViewById(R.id.cardviewMed);
//         CardView cardView2 = findViewById(R.id.cardviewMed2);
//         CardView cardView3 = findViewById(R.id.cardviewMed3);
//         CardView cardView4 = findViewById(R.id.cardviewMed4);
//         CardView cardView5 = findViewById(R.id.cardviewMed5);
//        CardView cardView6 = findViewById(R.id.cardviewMed6);
//        CardView cardView7= findViewById(R.id.cardviewMed7);
//     CardView cardView8 = findViewById(R.id.cardviewMed8);
//      CardView cardView9 = findViewById(R.id.cardviewMed9);
//    CardView cardView10 = findViewById(R.id.cardviewMed10);
//
//        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
////                if (newVal >0) {
////                    cardView.setVisibility(View.VISIBLE);
////
////
////                } else {
////                    cardView.setVisibility(View.GONE);
////                }
//
//
//
//               LinearLayout containerLayout = findViewById(R.id.medTimeLL);
////               containerLayout.removeAllViewsInLayout();
//                for (int k = 0; k < newVal; k++) {
//
//                    Toast.makeText(getApplicationContext(),"value changed", Toast.LENGTH_SHORT).show();
//                    View cardView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.medcard_view_layout, containerLayout, false);
//
//                    // Set values for views inside CardView based on user input
//                   // CardView titleTextView = cardView.findViewById(R.id.cardviewMed);
//                    // titleTextView.setText("Card " + (i+1));
//
//                    // Add CardView to container layout
//                    containerLayout.addView(cardView);
//
//                    // Set layout parameters for CardView
//                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardView.getLayoutParams();
//                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
//                    layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//                    layoutParams.setMargins(0, 0, 0, 16);
//                    cardView.setLayoutParams(layoutParams);
//
//            }
//        }});




//        dosage.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//                Toast.makeText(getApplicationContext(),"value changed", Toast.LENGTH_SHORT).show();
//
//
//                LinearLayout containerLayout = findViewById(R.id.containerLayout);
//
//                for (int k = 0; k < i1; k++) {
//
//
//                    View cardView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.medcard_view_layout, containerLayout, false);
//
//                    // Set values for views inside CardView based on user input
//                    CardView titleTextView = cardView.findViewById(R.id.cardviewMed);
//                    // titleTextView.setText("Card " + (i+1));
//
//                    // Add CardView to container layout
//                    containerLayout.addView(cardView);
//
//                    // Set layout parameters for CardView
//                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardView.getLayoutParams();
//                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
//                    layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//                    layoutParams.setMargins(0, 0, 0, 16);
//                    cardView.setLayoutParams(layoutParams);
//                }
//
//
//            }
//        });




//        timeselect= findViewById(R.id.medicine_time);
//        timeselect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {showTimePicker();}
//        });

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

    public void methodOnClick(@NonNull View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {


        }
    }
}

//    private void showTimePicker() {
//        Calendar mCurrentTime = Calendar.getInstance();
//        hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
//        minute = mCurrentTime.get(Calendar.MINUTE);
//        TimePickerDialog mTimePicker;
//        mTimePicker = new TimePickerDialog(medicine.this, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                hour = selectedHour;
//                minute = selectedMinute;
//                timeselect.setText(String.format(Locale.getDefault(), "%d:%d", selectedHour, selectedMinute));
//            }
//        }, hour, minute, false);
//        mTimePicker.setTitle("Select Time");
//        mTimePicker.show();
//   }

//    public void month(View view){
//        final Calendar today = Calendar.getInstance();
//        MonthPickerDialog.Builder builder = new Builder(Budget.this,
//                new MonthPickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(int selectedMonth, int selectedYear) { // on date set }
//                    }, today.get(Calendar.YEAR), today.get(Calendar.MONTH));
//}
