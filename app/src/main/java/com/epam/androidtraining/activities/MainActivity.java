package com.epam.androidtraining.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.epam.androidtraining.Constants;
import com.epam.androidtraining.R;
import com.epam.androidtraining.db.models.UserDb;
import com.epam.androidtraining.db.utils.DbUtils;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            loginBtn.setText("LogOut");
        }
    };
    private Button loginBtn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(new Runnable() {

            @Override
            public void run() {
                Cursor cursor = null;

                try {
                    cursor = getContentResolver().query(DbUtils.getTableUri(UserDb.class), null, null, null, null);

                    if (cursor != null && cursor.moveToFirst()) {
                        final String name = cursor.getString(cursor.getColumnIndex(UserDb.NAME));

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                } catch (final Exception e) {
                    Log.e(this.getClass().getSimpleName(), e.getLocalizedMessage());
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }).start();

        setContentView(R.layout.activity_main);
        //changes in new branch
        //I'm the first!
        Log.d(TAG, "onCreate is called");
        Log.d(TAG, "one more log:)");
        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                //           intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                //          startActivity(intent);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

//        startCalculatorActivity();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(Constants.RESULT_KEY));
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Constants.LOGIN_RESULT == resultCode) {
            startActivity(new Intent(MainActivity.this, CalculatorActivity.class));
        }
    }

    public void startCalculatorActivity() {
        startActivity(new Intent(this, CalculatorActivity.class));
    }

    public void someMethod() {
        Log.d(TAG, "some method called");
    }
}
