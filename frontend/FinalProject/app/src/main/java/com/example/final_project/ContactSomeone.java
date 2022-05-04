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
    public void callButton(View v){
        Intent intent = new Intent(getApplicationContext(),CallPage.class);
        startActivity(intent);
    }
    public void msgButton(View v){
        Intent intent = new Intent(getApplicationContext(),MessagePage.class);
        startActivity(intent);
    }
    public void goBack(View v){
        Intent intent = new Intent(getApplicationContext(),Menu.class);
        startActivity(intent);
    }
}