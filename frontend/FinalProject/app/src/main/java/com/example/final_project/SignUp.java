package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SignUp extends AppCompatActivity {

    EditText name;
    EditText pass;
    Button sign_up;
    String rate;
    String strResult;
    TextView rateDisplay;
    URL url;
    public class DownloadTask extends AsyncTask<String, Void, String> {
        public String rateInside = "" ;


        protected String doInBackground(String... urls){
            String getting = "" ;

            HttpURLConnection http;

            try{
                url = new URL(urls[0]);
                http = (HttpURLConnection) url.openConnection();

                InputStream in = http.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while( data != -1){
                    char current = (char) data;
                    getting += current;
                    data = reader.read();

                }
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
            return getting;
        }


        protected void onPostExecute(String s){
            super.onPostExecute(s);

            try{
                JSONObject json = new JSONObject(s);
                rate = json.getString("rate");
                rateDisplay.setText("Current rate: 1 USD = " + rate + " LBP");
                rateInside = rate;

            }catch(Exception e){
                e.printStackTrace();

            }

        }


    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name= (EditText) findViewById(R.id.name);
        pass= (EditText) findViewById(R.id.pass);
        sign_up= (Button) findViewById(R.id.button);
        String url = "http://192.168.3.218/CSC498G-Project-1/backend/api.php";
        DownloadTask task = new DownloadTask();
        task.execute(url);
        rate = task.rateInside;


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
        String post_to_database = "http://192.168.3.218/CSC498G-Project-1/backend/api.php" + "?email=" + name.getText().toString() + "&" + "user_password=" + pass.getText().toString();
        Intent intent=new Intent (getApplicationContext(), Menu.class);
        startActivity(intent);
    }

}