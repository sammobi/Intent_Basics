package com.example.simpalm.intent_basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btnOpen_Browser, btnSend_Mail, btnSend_SMS, btnCall, mbtnfindmyage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpen_Browser = (Button) findViewById(R.id.Open_browserBtn);
        btnSend_Mail = (Button) findViewById(R.id.Send_MailBtn);
        btnSend_SMS = (Button) findViewById(R.id.Send_SMSBtn);
        btnCall = (Button) findViewById(R.id.CallBtn);
        mbtnfindmyage = (Button) findViewById(R.id.btnFindMyAge);

        btnOpen_Browser.setOnClickListener(this);
        btnSend_SMS.setOnClickListener(this);
        btnSend_Mail.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        mbtnfindmyage.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Open_browserBtn:

                Intent i = new Intent
                        (MainActivity.this, OpenBrowserActivity.class);
                startActivity(i);  //a method of Activity class
                //Destroy the current activity


                break;
            case R.id.Send_MailBtn:

                Intent j = new Intent
                        (MainActivity.this, SendMailActivity.class);
                startActivity(j);  //a method of Activity class
                //Destroy the current activity


                break;

            case R.id.Send_SMSBtn:
                Intent k = new Intent
                        (MainActivity.this, SendSMSActivity.class);
                startActivity(k);  //a method of Activity class
                //Destroy the current activity


                break;

            case R.id.CallBtn:

                Intent l = new Intent
                        (MainActivity.this, OpenBrowserActivity.class);
                l.putExtra("CameFrom", "Call");


                startActivity(l);  //a method of Activity class
                //Destroy the current activity


                break;

            case R.id.btnFindMyAge:

                Intent m = new Intent
                        (MainActivity.this, FindMyAgeActivity.class);
                m.putExtra("CameFrom", "Call");


                startActivity(m);  //a method of Activity class
                //Destroy the current activity


                break;


        }


    }
}
