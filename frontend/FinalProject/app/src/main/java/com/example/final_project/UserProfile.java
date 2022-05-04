package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        et= (EditText) findViewById(R.id.editTextNumber);
        String[] arraySpinner = new String[] {
                "--select a choice--","I do not mind calling and getting called","i would rather not call or get called","i would rather only talk to experts"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner);
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
            }
        });
    }
    public void goBackToMenu(View v){
        startActivity(new Intent (getApplicationContext(), Menu.class));
    }



}