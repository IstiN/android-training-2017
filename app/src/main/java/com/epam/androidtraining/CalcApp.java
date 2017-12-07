package com.epam.androidtraining;

import android.app.Application;
import android.widget.Toast;

import com.epam.androidtraining.db.IDbOperations;
import com.epam.androidtraining.utils.ContextHolder;
import com.epam.training.imageloader.Malevich;

/**
 * Created by evgen on 23.10.2017.
 */

public class CalcApp extends Application {

    private IDbOperations mDbOperations;

    @Override
    public void onCreate() {
        super.onCreate();
        ContextHolder.setContext(this);
        Toast.makeText(this, "App is created", Toast.LENGTH_SHORT).show();

        Malevich.INSTANCE.setConfig(new Malevich.Config(getCacheDir()));
        mDbOperations = IDbOperations.Imp.newInstance();
    }

    @Override
    public Object getSystemService(String name) {
        if (name.equals(IDbOperations.Imp.SYSTEM_SERVICE_NAME)) {
            return mDbOperations;
        }
        return super.getSystemService(name);
    }
}
