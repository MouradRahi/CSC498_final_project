package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText name;
    EditText pass;
    Button sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name= (EditText) findViewById(R.id.name);
        pass= (EditText) findViewById(R.id.pass);
        sign_up= (Button) findViewById(R.id.button);
        if(pass.getText().toString().equals("") && name.getText().toString().equals("")){
            sign_up.setEnabled(false);
        }
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sign_up.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (pass.getText().toString().equals("")){
                    sign_up.setEnabled(false);
                }
                else{
                    sign_up.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (pass.getText().toString().equals("")){
                    sign_up.setEnabled(false);
                }
                else{
                    sign_up.setEnabled(true);
                }
            }
        });
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sign_up.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (name.getText().toString().equals("")){
                    sign_up.setEnabled(false);
                }
                else{
                    sign_up.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (name.getText().toString().equals("")){
                    sign_up.setEnabled(false);
                }
                else{
                    sign_up.setEnabled(true);
                }
            }
        });
    }
    public void next(View v){
        Intent intent=new Intent (getApplicationContext(), Menu.class);
        startActivity(intent);
    }

}