package com.example.suvrat.helpdadministrator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText nameEdittext,dobEditText,genderEditText,phoneNumber1EditText,phoneNumber2EditText,address1EditText,address2EditText,landmarkEditText,stateEditText,cityEditText,aadharnumberEditText,pannumberEditText,transportationEditText,bankaccountEditText,modeofpaymentEditText;
Button submit;
FirebaseDatabase database;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();

        //Declaring the edittexts ------
        nameEdittext=findViewById(R.id.name);
        dobEditText=findViewById(R.id.dob);
        genderEditText=findViewById(R.id.gender);
        phoneNumber1EditText=findViewById(R.id.phonenumber1);
        phoneNumber2EditText=findViewById(R.id.phonenumber2);
        address1EditText=findViewById(R.id.address1);
        address2EditText=findViewById(R.id.address2);
        landmarkEditText=findViewById(R.id.landmark);
        stateEditText=findViewById(R.id.state);
        cityEditText=findViewById(R.id.city);
        aadharnumberEditText=findViewById(R.id.aadharnumber);
        pannumberEditText=findViewById(R.id.pannumber);
        transportationEditText=findViewById(R.id.transportation);
        bankaccountEditText=findViewById(R.id.bankaccount);
        modeofpaymentEditText=findViewById(R.id.modeofpayment);
        submit = findViewById(R.id.submit);
        //----------------------



        //submit button functionalty
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //edittexts value fetch
                String name = nameEdittext.getText().toString();
                String dob = dobEditText.getText().toString();
                String gender = genderEditText.getText().toString();
                String phonenumber1 = phoneNumber1EditText.getText().toString();
                String phonenumber2 = phoneNumber2EditText.getText().toString();
                String address1 = address1EditText.getText().toString();
                String address2 = address2EditText.getText().toString();
                String landmark= landmarkEditText.getText().toString();
                String state = stateEditText.getText().toString();
                String city = cityEditText.getText().toString();
                String addharnumber = aadharnumberEditText.getText().toString();
                String pannumber = pannumberEditText.getText().toString();
                String transportation = transportationEditText.getText().toString();
                String bankaccount = bankaccountEditText.getText().toString();
                String modeofpayment = modeofpaymentEditText.getText().toString();
                //------------------------


                final Maid maid = new Maid();
                maid.setName(name);
                maid.setDob(dob);
                maid.setGender(gender);
                maid.setPhonenumber1(phonenumber1);
                maid.setPhonenumber2(phonenumber2);
                maid.setAddress1(address1);
                maid.setAddress2(address2);
                maid.setLandmark(landmark);
                maid.setState(state);
                maid.setCity(city);
                maid.setAadharnumber(addharnumber);
                maid.setPannumber(pannumber);
                maid.setTransportation(transportation);
                maid.setBankaccount(bankaccount);
                maid.setModeofpayment(modeofpayment);

                database.getReference().child(phonenumber1 + " " + name).setValue(maid).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "The values have been submitted", Toast.LENGTH_SHORT).show();
                        }
                     Intent intent = new Intent(MainActivity.this,submitScreen.class);
                        startActivity(intent);
                    }
                });


            }
        });


    }

}
