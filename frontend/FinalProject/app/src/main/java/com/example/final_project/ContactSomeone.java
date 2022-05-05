package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ContactSomeone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_someone);
    }
    public void contactRandom(View v){
        startActivity(new Intent(getApplicationContext(),CallPage.class));
    }
    public void contactExpert(View v){
        startActivity(new Intent(getApplicationContext(),ContactExpert.class));
    }

}