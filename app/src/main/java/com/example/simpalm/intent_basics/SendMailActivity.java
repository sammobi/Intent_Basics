package com.example.simpalm.intent_basics;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMailActivity extends Activity {

    EditText mToEt, mCcEt, mBccEt, mSubjectEt, mMessageEt;

    Button mSendMailBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__mail);


        mToEt = (EditText) findViewById(R.id.to_et);
        mCcEt = (EditText) findViewById(R.id.cc_et);
        mSubjectEt = (EditText) findViewById(R.id.subject_et);
        mMessageEt = (EditText) findViewById(R.id.message_et);
        mSendMailBtn = (Button) findViewById(R.id.send_mail_btn);
        mBccEt = (EditText) findViewById(R.id.bcc_et);


        mSendMailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSendMail();


            }
        });


    }

    private void validateAndSendMail() {

        String to = mToEt.getText().toString();
        if (to.length() < 1) {

            ShowAlertDialog("Please enter To value");

            return;
        }
        String cc = mCcEt.getText().toString();
        if (cc.length() < 1) {

            ShowAlertDialog("Please enter CC value");

            return;
        }
        String bcc = mBccEt.getText().toString();
        if (bcc.length() < 1) {

            ShowAlertDialog("Please enter Bcc value");

            return;
        }
        String subject = mSubjectEt.getText().toString();
        if (subject.length() < 1) {

            ShowAlertDialog("Please enter Subject");

            return;
        }
        String message = mMessageEt.getText().toString();
        if (message.length() < 1) {

            ShowAlertDialog("Please enter Message");

            return;
        }
        String TO[]={to};
        String CC[]={cc};
        String BCC[]={bcc};

        SendMail(TO, CC, BCC, subject, message);

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

    private void SendMail(String to[], String cc[], String bcc[], String subject, String message) {


        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_BCC, bcc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(emailIntent);
    }


}
