package com.example.mohammedhassan.droplife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    Map<String, String> alanisawesomeMap = new HashMap<String, String>();
    Map<String, Map<String, String>> users = new HashMap<String, Map<String, String>>();
    private Firebase mRes ;
    Button sendData ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final EditText Name , Email , Password , NID , age , btype ;
        Button signup ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Firebase.setAndroidContext(this);
        sendData = (Button)findViewById(R.id.Value1);
        mRes = new Firebase("https://dropapp-e408b.firebaseio.com/");


        Name = (EditText) findViewById(R.id.textname);
        Email = (EditText) findViewById(R.id.textemail);
        Password = (EditText) findViewById(R.id.textpassword);
        NID = (EditText) findViewById(R.id.textNid);
        btype = (EditText)findViewById(R.id.textbtype);
        age = (EditText)findViewById(R.id.textage);
        signup = (Button)findViewById(R.id.SignupBttn);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Firebase usersRef = mRes.child("users");

                alanisawesomeMap.put("Name",Name.getText().toString() );
                alanisawesomeMap.put("Email",Email.getText().toString());
                alanisawesomeMap.put("Password",Password.getText().toString());
                alanisawesomeMap.put("NID",NID.getText().toString() );
                alanisawesomeMap.put("Btype",btype.getText().toString() );
                alanisawesomeMap.put("age",age.getText().toString() );


                //users.put("alanisawesome", alanisawesomeMap);
                usersRef.push().setValue(alanisawesomeMap);

                Intent i = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });



    }


}
