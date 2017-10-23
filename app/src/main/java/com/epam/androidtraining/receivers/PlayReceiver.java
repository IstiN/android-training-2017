package com.epam.androidtraining.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.epam.androidtraining.services.PlayerService;

/**
 * Created by evgen on 23.10.2017.
 */

public class PlayReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, PlayerService.class));
    }
}
