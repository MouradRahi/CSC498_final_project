package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity2 extends AppCompatActivity {


    private TextView quote1;
    private TextView quote2;
    private TextView quote3;
    private TextView quote4;
    private String quote;

    public class DownloadTask extends AsyncTask<String, Void, String> {


        protected String doInBackground(String... urls){
            String result = "";
            URL url;
            HttpURLConnection http;

            try{
                url = new URL(urls[0]);
                http = (HttpURLConnection) url.openConnection();

                InputStream in = http.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while( data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();

                }
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }

            return result;
        }


        protected void onPostExecute(String s){
            super.onPostExecute(s);

            try{
                JSONObject json1 = new JSONObject(s);
                quote = json1.getString("content");
                quote1.setText(quote);



            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String amount =  ""; //get the amount from the view
        String url1 = "https://api.quotable.io/random";
        String url2 = "https://api.quotable.io/random";
        String url3 = "https://api.quotable.io/random";
        String url4 = "https://api.quotable.io/random";
        DownloadTask task1 = new DownloadTask();
        task1.execute(url1);
        quote2.setText(quote1.getText().toString());
        DownloadTask task2 = new DownloadTask();
        task2.execute(url2);
        quote3.setText(quote2.getText().toString());
        quote2.setText(quote1.getText().toString());
        DownloadTask task3 = new DownloadTask();
        task3.execute(url3);
        quote4.setText(quote3.getText().toString());
        quote3.setText(quote2.getText().toString());
        quote2.setText(quote1.getText().toString());
        DownloadTask task4 = new DownloadTask();
        task4.execute(url4);
        quote1= (TextView) findViewById(R.id.textView14);
        quote2= (TextView) findViewById(R.id.textView17);
        quote3= (TextView) findViewById(R.id.textView16);
        quote4= (TextView) findViewById(R.id.textView15);
        //quote1.setText();


    }

    public void backToMenu(View v){
        startActivity(new Intent(getApplicationContext(),Menu.class));
    }
}