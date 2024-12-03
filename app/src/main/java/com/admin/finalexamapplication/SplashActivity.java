package com.admin.finalexamapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashfile);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // After 5 seconds, start the MainActivity
                Intent intent = new Intent(SplashActivity.this, SelectionPage.class);
                startActivity(intent);
                finish();  // Close the SplashActivity
            }
        }, 4000);  // Wait for 4 seconds
    }
}

