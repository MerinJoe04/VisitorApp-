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

                Toast.makeText(getApplicationContext(),fname+" "+lname+" "+purpose+" "+meet,Toast.LENGTH_LONG).show();

            }
        });

    }
}