package com.example.simpalm.intent_basics;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendSMSActivity extends Activity {

    EditText recipientET, enterMessageEt;
    Button sendTextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__sms);

        recipientET = (EditText) findViewById(R.id.recipient_Et);
        enterMessageEt = (EditText) findViewById(R.id.enter_messageEt);
        sendTextBtn = (Button) findViewById(R.id.send_TextBtn);


        sendTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validMessage();
            }
        });


    }

    private void validMessage() {


        String recipient = recipientET.getText().toString();
        if (recipient.length() < 1) {

            ShowAlertDialog("Please enter the recipient");

            return;
        }
        String message = enterMessageEt.getText().toString();
        if (message.length() < 1) {

            ShowAlertDialog("Please enter CC value");

            return;
        }

        //  String TO[] = {to};


        sendTextMessage(recipient, message);


    }

    private void ShowAlertDialog(String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss(); //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public void sendTextMessage(String to, String message) {
        to = to.replaceAll("#", ";");

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("sms_body", message);
        sendIntent.putExtra("address", new String(to));
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);


    }

}
