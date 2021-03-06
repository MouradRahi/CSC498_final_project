package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        /*
        if (user not willing to call)->setEnable of contact someone to false
        else set it to true
         */
    }

    public void contactSomeone(View v){
        Intent intent=new Intent (getApplicationContext(), ContactSomeone.class);
        startActivity(intent);
    }
    public void motivational(View v){
        Intent intent=new Intent (getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }
    public void meme(View v){
        Intent intent=new Intent (getApplicationContext(), WholesomeMemes.class);
        startActivity(intent);
    }
    public void profile(View v){
        Intent intent=new Intent (getApplicationContext(), UserProfile.class);
        startActivity(intent);
    }
}