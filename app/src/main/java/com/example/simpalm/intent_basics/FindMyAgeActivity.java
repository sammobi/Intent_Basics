package com.example.simpalm.intent_basics;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FindMyAgeActivity extends Activity {


    Button mFindMyCurrentAgeBtn;
    TextView mMyCurrentAgeTv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_my_age);


        mFindMyCurrentAgeBtn = (Button) findViewById(R.id.btnFindCurrentAge);
        mMyCurrentAgeTv = (TextView) findViewById(R.id.tvMyAge);


        mFindMyCurrentAgeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindMyAgeActivity.this, EnterBirthYearActivity.class);
                startActivityForResult(intent, 2);// Activity is started with requestCode 2
            }
        });
    }

    // Call Back method  to get the Message form other Activity

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if (requestCode == 2) if (null != data) {
            String message = data.getStringExtra("MESSAGE");
            mMyCurrentAgeTv.setText(message);
        }


    }

}
