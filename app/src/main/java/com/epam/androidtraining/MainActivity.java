package com.epam.androidtraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String LOG = "MainActivity";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //changes in new branch
        //I'm the first!
        Log.d(LOG, "onCreate is called");
        System.out.println("some info");
    }

}
