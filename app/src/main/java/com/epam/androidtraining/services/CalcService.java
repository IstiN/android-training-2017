package com.epam.androidtraining.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import com.epam.androidtraining.Constants;

import java.util.concurrent.TimeUnit;

/**
 * Created by evgen on 23.10.2017.
 */

public class CalcService extends Service {

    public static final String TAG = CalcService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        final PendingIntent pi = intent.getParcelableExtra(Constants.PI_KEY);
        final Integer first = intent.getIntExtra(Constants.FIRST_KEY, 0);
        final Integer second = intent.getIntExtra(Constants.SECOND_KEY, 0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = first + second;
                    TimeUnit.SECONDS.sleep(5);
                    Intent resultIntent = new Intent().putExtra(Constants.RESULT_KEY, result);
                    pi.send(CalcService.this, Constants.SERVICE_RESULT, resultIntent);
                } catch (InterruptedException | PendingIntent.CanceledException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
}
