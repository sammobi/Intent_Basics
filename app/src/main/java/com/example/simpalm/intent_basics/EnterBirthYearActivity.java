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

public class EnterBirthYearActivity extends Activity {

    EditText mEnterBirthYearEt;
    Button mCalculateMyAgeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_birth_year);

        mEnterBirthYearEt = (EditText) findViewById(R.id.etMyYearofBirth);
        mCalculateMyAgeBtn = (Button) findViewById(R.id.btnMyAge);


        mCalculateMyAgeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEnterBirthYearEt.getText().toString().length() == 0)
                    mEnterBirthYearEt.setError("Year of Birth is Required!");

                String message = mEnterBirthYearEt.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("MESSAGE", message);
                setResult(2, intent);
                finish();//finishing activity
            }

        });

    }


}
