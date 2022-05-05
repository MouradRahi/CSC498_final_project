package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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


    private void sendPostRequest(String givenAmount, String givenRate , String givenCurrency) {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String>{

            @Override
            protected String doInBackground(String... params) {

                String paramAmount = params[0];
                String paramRate = params[1];
                String paramCurrency = params[2];


                HttpClient httpClient = new DefaultHttpClient();


                HttpPost httpPost = new HttpPost("http://192.168.11.108/CSC498G-Project-1/backend/post.php");


                BasicNameValuePair amountBasicNameValuePair = new BasicNameValuePair("amount", paramAmount);
                BasicNameValuePair rateBasicNameValuePAir = new BasicNameValuePair("rate", paramRate);
                BasicNameValuePair currencyBasicNameValuePAir = new BasicNameValuePair("currency", paramCurrency);


                List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
                nameValuePairList.add(amountBasicNameValuePair);
                nameValuePairList.add(rateBasicNameValuePAir);
                nameValuePairList.add(currencyBasicNameValuePAir);


                try {

                    UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList);

                    httpPost.setEntity(urlEncodedFormEntity);

                    try {

                        HttpResponse httpResponse = httpClient.execute(httpPost);


                        InputStream inputStream = httpResponse.getEntity().getContent();

                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                        StringBuilder stringBuilder = new StringBuilder();

                        String bufferedStrChunk = null;

                        while((bufferedStrChunk = bufferedReader.readLine()) != null){
                            stringBuilder.append(bufferedStrChunk);
                        }

                        return stringBuilder.toString();

                    } catch (ClientProtocolException cpe) {
                        System.out.println("First Exception case of HttpResponse :" + cpe);
                        cpe.printStackTrace();
                    } catch (IOException ioe) {
                        System.out.println("Second Exception case of HttpResponse :" + ioe);
                        ioe.printStackTrace();
                    }

                } catch (UnsupportedEncodingException uee) {
                    System.out.println("An Exception given because of UrlEncodedFormEntity argument :" + uee);
                    uee.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);

                try{
                    Log.i("s" , s);
                    JSONObject json = new JSONObject(s);
                    strResult = json.getString("result");
                    result.setText(strResult);
                    result.animate().alpha(1.0F);
                    Log.i("result" , strResult);


                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(givenAmount, givenRate , givenCurrency);
    }

    public void next(View v){
        String post_to_database = "http://192.168.3.218/FinalProject/v1/signup.php" + "?email=" + name.getText().toString() + "&" + "user_password=" + pass.getText().toString();
        Intent intent=new Intent (getApplicationContext(), Menu.class);
        startActivity(intent);
    }

}