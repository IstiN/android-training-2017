package com.epam.androidtraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //changes in new branch
        //I'm the first!
        Log.d(TAG, "onCreate is called");
        Log.d(TAG, "one more log :)");
    }

    public void someMethod() {
        Log.d(TAG, "some method called");
    }
}
