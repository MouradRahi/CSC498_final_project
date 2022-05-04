package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {

    private Button nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        nm=findViewById(R.id.no_mind);
    }
    public void goBackToMenu(View v){
        startActivity(new Intent (getApplicationContext(), Menu.class));
    }
    public void noMind(View v){
        startActivity(new Intent (getApplicationContext(), MoC.class));
    }
    public void Mind(View v){
        Toast.makeText(this, "you have chosen to not receive calls and messages", Toast.LENGTH_LONG).show();
    }


}