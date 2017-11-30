package com.epam.androidtraining;

import android.app.Application;
import android.widget.Toast;

import com.epam.training.imageloader.Malevich;

/**
 * Created by evgen on 23.10.2017.
 */

public class CalcApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "App is created", Toast.LENGTH_SHORT).show();

        Malevich.INSTANCE.setConfig(new Malevich.Config(getCacheDir()));
    }
}
