package com.example.stopwatch_2;

import android.os.Handler;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityStop extends AppCompatActivity {

    private Button mStartBtn, mResetBtn, mPauseBtn;
    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        mStartBtn = (Button) findViewById(R.id.start_btn);
        mResetBtn = (Button) findViewById(R.id.reset_btn);
        mPauseBtn = (Button) findViewById(R.id.pause_btn);

        runTimer();
    }

    public void onClickStart(View v) {
        v.setVisibility(View.INVISIBLE);
        mPauseBtn.setVisibility(View.VISIBLE);
        mResetBtn.setVisibility(View.INVISIBLE);
        running = true;
    }

    public void onClickPause(View v) {
        v.setVisibility(View.INVISIBLE);
        mStartBtn.setVisibility(View.VISIBLE);
        mResetBtn.setVisibility(View.VISIBLE);
        running = false;
    }

    public void onClickReset(View v) {
        v.setVisibility(View.INVISIBLE);
        mStartBtn.setVisibility(View.VISIBLE);
        mResetBtn.setVisibility(View.INVISIBLE);
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.time_view);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = seconds/3600;
                int min = (seconds%3600)/60;
                int sec = seconds %60;
                String time = String.format("%02d:%02d:%02d", hour, min, sec);
                timeView.setText(time);
                if(running) {
                    seconds++;
                }
                handler.postDelayed(this, 100);
            }
        });
    }

}