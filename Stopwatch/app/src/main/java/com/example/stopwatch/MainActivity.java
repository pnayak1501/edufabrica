package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int seconds=0;
    boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
        if(savedInstanceState!=null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
    }

    public void onStart(View view) {
        running=true;
    }

    public void onPause(View view) {
        running=false;
    }

    public void onReset(View view) {
        running=false;
        seconds=0;
    }
    public void onStop(){
        super.onStop();
        running=false;
    }
    public void onSavedInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
    }
    public void runTimer() {
        final TextView timer = findViewById(R.id.timer_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int min = (seconds % 3600) / 60;
                int sec = seconds % 60;
                String time_format = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, min, sec);
                timer.setText(time_format);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }}

