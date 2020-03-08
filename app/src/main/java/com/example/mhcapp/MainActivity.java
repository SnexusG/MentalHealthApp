package com.example.mhcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar splash_progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splash_progress_bar = findViewById(R.id.splash_progress);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(splash_progress_bar.getProgress() != 100){
                    splash_progress_bar.incrementProgressBy(20);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(MainActivity.this, SignUP_SIgnIn.class);
                startActivity(intent);
                finish();
            }
        });
        t1.start();
    }
}
