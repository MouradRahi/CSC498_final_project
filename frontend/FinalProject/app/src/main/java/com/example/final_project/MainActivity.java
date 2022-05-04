package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Signup(View v){
        Intent intent=new Intent (getApplicationContext(), SignUp.class);
        startActivity(intent);
    }
    public void Login(View v){
        Intent intent=new Intent (getApplicationContext(), LogIn.class);
        startActivity(intent);
    }
}