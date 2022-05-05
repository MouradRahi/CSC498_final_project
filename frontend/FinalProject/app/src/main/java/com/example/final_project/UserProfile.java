package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {

    private Button nm;
    private EditText et;
    private EditText name;
    private Button back;
    private Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        et= (EditText) findViewById(R.id.editTextNumber);
        name= (EditText) findViewById(R.id.editTextTextPersonName);
        nm= (Button) findViewById(R.id.button9);
        back= (Button) findViewById(R.id.button7);

        //if user has just signed in aka if user does not have a profile yet
        back.setEnabled(false);
        String[] arraySpinner = new String[] {
                "--select a choice--","I do not mind calling and getting called","i would rather not call or get called","i would rather only talk to experts"
        };
        s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                if(arraySpinner[position].equals("I do not mind calling and getting called") || arraySpinner[position].equals("i would rather only talk to experts") ){
                    et.setAlpha(1.0F);
                    et.setEnabled(true);
                    Toast.makeText(UserProfile.this, "Enter your phone number", Toast.LENGTH_SHORT).show();
                }
                else if(arraySpinner[position].equals("--select a choice--")){

                }
                else{
                    et.setAlpha(0.0F);
                    et.setEnabled(false);
                    Toast.makeText(UserProfile.this, "You will not receive any calls", Toast.LENGTH_SHORT).show();
                }
            }


            public void onNothingSelected(AdapterView<?> arg0) {
                et.setAlpha(0.0F);
                et.setEnabled(false);
                nm.setEnabled(false);
            }
        });
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nm.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (et.getText().toString().equals("") && et.isEnabled()){
                    nm.setEnabled(false);
                }
                else{
                    nm.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (et.getText().toString().equals("") && et.isEnabled()){
                    nm.setEnabled(false);
                }
                else{
                    nm.setEnabled(true);
                }
            }
        });
    }
    public void save(View v){
        //saves data of profile into the database
        back.setEnabled(true);
    }
    public void goBackToMenu(View v){
        startActivity(new Intent (getApplicationContext(), Menu.class));
    }



}