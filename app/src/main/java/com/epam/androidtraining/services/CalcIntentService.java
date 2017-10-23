package com.epam.androidtraining.services;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.epam.androidtraining.Constants;

import java.util.concurrent.TimeUnit;

/**
 * Created by evgen on 23.10.2017.
 */

public class CalcIntentService extends IntentService {

    public static final String TAG = CalcIntentService.class.getSimpleName();

    public CalcIntentService() {
        super("CalcApp");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "onhandleIntent: ");
        final PendingIntent pi = intent.getParcelableExtra(Constants.PI_KEY);
        final Integer first = intent.getIntExtra(Constants.FIRST_KEY, 0);
        final Integer second = intent.getIntExtra(Constants.SECOND_KEY, 0);
        try {
            Integer result = first + second;
            TimeUnit.SECONDS.sleep(5);
            Intent resultIntent = new Intent().putExtra(Constants.RESULT_KEY, result);
            pi.send(CalcIntentService.this, Constants.SERVICE_RESULT, resultIntent);
        } catch (InterruptedException | PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }

}
