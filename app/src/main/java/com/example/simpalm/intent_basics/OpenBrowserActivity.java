package com.example.simpalm.intent_basics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class OpenBrowserActivity extends Activity {

    EditText Etenter_website;
    Button btnGo;
    WebView Browser;


    private class WebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open__browser);
        Etenter_website = (EditText) findViewById(R.id.enter_websiteEt);
        btnGo = (Button) findViewById(R.id.GOBtn);

        Browser = (WebView) findViewById(R.id.WebEngine);


        btnGo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Browser.setWebViewClient(new WebClient());
                Browser.loadUrl("http://" + Etenter_website.getText().toString());
            }
        });
    }

    private void call() {
        Intent in=new Intent(Intent.ACTION_CALL, Uri.parse("0000000000"));
        try{
            startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded", Toast.LENGTH_SHORT).show();
        }
    }

}





