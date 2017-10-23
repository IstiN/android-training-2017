package com.epam.androidtraining;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by evgen on 23.10.2017.
 */

public class CalcApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "App is created", Toast.LENGTH_SHORT).show();
    }
}
