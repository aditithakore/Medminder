package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {


    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogin;
    TextView textviewSignup;
    ProgressBar progress;
    CheckBox remember;
    JSONObject reader = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextUsername= findViewById(R.id.username);
        textInputEditTextPassword=findViewById(R.id.password);
        buttonLogin=findViewById(R.id.buttonLogin);
        textviewSignup = findViewById(R.id.signUpText);
        progress = findViewById(R.id.progress);
       remember=findViewById(R.id.remember);




        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.apply();
                    Toast.makeText(login.this,"Checked",Toast.LENGTH_SHORT).show();

                }
                else{
                    SharedPreferences preferences= getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                    Toast.makeText(login.this,"Unchecked",Toast.LENGTH_SHORT).show();


                }

            }
        });




        textviewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),signup.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username, password;
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());

                if(TextUtils.isEmpty(textInputEditTextUsername.getText().toString())){

                    textInputEditTextUsername.setError("UserName is compulsory");
                }

                if(TextUtils.isEmpty(textInputEditTextPassword.getText().toString())){

                    textInputEditTextPassword.setError("Password is compulsory");
                }




                if (!username.equals("") && !password.equals("")) {


                    progress.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;

                            PutData putData = new PutData("https://ammoniac-initial.000webhostapp.com/login.php","POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    Log.d("data_login","data= "+result);

                                    try {
                                        reader = new JSONObject(result);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    try {
                                        if (reader.getString("status").equals("Login Success")) {
                                            Bundle bundle = new Bundle();
                                           String myMessage = reader.getString("user_id");
                                            bundle.putString("user_id", myMessage );
//                                            AppointmentList appointmentList = new AppointmentList();
//                                            appointmentList.setArguments(bundle);

                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), dashboard.class);
                                            intent.putExtras(bundle);
                                            startActivity(intent);
                                            finish();
                                        }
                                        else{

                                            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    catch (Exception e){
                                        System.out.println("Error for Login from here : ");
                                        e.printStackTrace();

                                    }


                                    progress.setVisibility(View.GONE);
                                    //  Log.i("PutData", result);
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public  String getUserId(){
        try {
            if (reader.getString("status").equals("Login Success")) {

                return reader.getString("user_id");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    int counter=0;
    @Override
    public void onBackPressed() {
        counter++;
        if(counter==1)
            super.onBackPressed();
        }

}