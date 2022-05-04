package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MoC extends AppCompatActivity {

    private Button call;
    private Button msg;
    private Button both;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_c);
        call=findViewById(R.id.willing_to_call);
        msg=findViewById(R.id.willing_to_msg);
        both=findViewById(R.id.both);

    }
    public void done(View v){
        startActivity(new Intent(getApplicationContext(), UserProfile.class));
    }
    public void call(View v){
        Toast.makeText(this, "you have chosen to only receive calls", Toast.LENGTH_LONG).show();
    }
    public void msg(View v){
        Toast.makeText(this, "you have chosen to only receive messages", Toast.LENGTH_LONG).show();
    }
    public void both(View v){
        Toast.makeText(this, "you have chosen to receive both calls and messages", Toast.LENGTH_LONG).show();
    }
}