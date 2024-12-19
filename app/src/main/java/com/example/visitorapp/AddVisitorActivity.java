package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddVisitorActivity extends AppCompatActivity {


    Button b5,b55;

    EditText et1,et2,et3,et4;


    String fname,lname,purpose,meet;
    Integer num1,num2,sum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_visitor);

        et1=(EditText) findViewById(R.id.fn);
        et2=(EditText) findViewById(R.id.ln);
        et3=(EditText) findViewById(R.id.pn);
        et4=(EditText) findViewById(R.id.wn);

        b5=(Button)  findViewById(R.id.gn);
        b55=(Button)  findViewById(R.id.sn);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob5= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ob5);
            }
        });

        b55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname=et1.getText().toString();
                lname=et2.getText().toString();
                purpose=et3.getText().toString();
                meet=et4.getText().toString();
                if(fname.isEmpty()||lname.isEmpty()||purpose.isEmpty()||meet.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"ALL FIELDS ARE MANDATORY",Toast.LENGTH_LONG).show();
                }
                else
                {
                callApi();

                }
            }

            private void callApi() {

                String Apiurl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data = new JSONObject();
               try {
                   data.put("firstname",fname);
                   data.put("lastname",lname);
                   data.put("purpose",purpose);
                   data.put("whomToMeet",meet);
               }
            catch (JSONException e)
            {
                throw new RuntimeException(e);
            }
                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST,
                        Apiurl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"SUCCESSFULLY ADDED", Toast.LENGTH_LONG).show(),
                        error ->  Toast.makeText(getApplicationContext(),"Something went  wrong", Toast.LENGTH_LONG).show()
                );
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(request);

            }


        });

    }
}