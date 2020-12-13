package com.example.elevatorthread;

import android.app.Activity;
import android.os.Bundle;

public class ThreadEX extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ThreadEXView(this));
    }
}
