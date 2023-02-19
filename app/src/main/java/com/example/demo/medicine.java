package com.example.demo;



import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
   Button addButton;
    TextView startDate,endDate;
    Calendar calendar=Calendar.getInstance();
    CheckBox monday,tuesday,wednesday,thursday,friday,saturday,sunday,everyday;
    static boolean mon=false,tue=false,wed=false,thurs=false,fri=false,sat=false,sun=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        medname=findViewById(R.id.edit_med_name);


        save=findViewById(R.id.imageViewSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String med_name,med_startDate,med_endDate,time;
                med_name=String.valueOf(medname.getText());
                med_startDate=String.valueOf(startDate.getText());
                med_endDate=String.valueOf(endDate.getText());
                boolean[] days={mon,tue,wed,thurs,fri,sat,sun};
                for (int j=0;j<=i;j++) {
                    int s1=R.id.medicine_time+i;
                    EditText editText=findViewById(s1);
                    Toast.makeText(getApplicationContext()," "+editText.getText()+" "+i,Toast.LENGTH_SHORT).show();
                }

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



        parentLinearLayout=(LinearLayout) findViewById(R.id.containerLayout);
addButton=findViewById(R.id.add_field_button);

addButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView=inflater.inflate(R.layout.medcard_view_layout, null);

        rowView.findViewById(R.id.medicine_time).setId(R.id.medicine_time+i);
        Toast.makeText(getApplicationContext(),"tost of i "+ i,Toast.LENGTH_SHORT).show();


        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);

        Toast.makeText(getApplicationContext(),"" +findViewById(R.id.medicine_time).getId(),Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"" +findViewById(R.id.medicine_time+i).getId(),Toast.LENGTH_SHORT).show();

        i=i+1;
}});



timeselect=findViewById(R.id.medicine_time0);


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





   public void methodOnClick(View view) {
       boolean checked = ((CheckBox) view).isChecked();
       switch (view.getId()) {


       }
   }

    }

