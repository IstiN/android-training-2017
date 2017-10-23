package com.epam.androidtraining.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.epam.androidtraining.Constants;
import com.epam.androidtraining.R;

/**
 * Created by evgen on 23.10.2017.
 */

public class LoginActivity extends Activity {

    public static final String TAG = LoginActivity.class.getSimpleName();
    public static final String SAVED_DATA = "saved_data";

    private EditText mEditTextView;
    private String savedString = Constants.EMPTY_STRING;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_login);
        findViewById(R.id.set_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CalculatorActivity.class));
                //example: saveinctancestate
//                savedString = savedString + mEditTextView.getText().toString();
//                Toast.makeText(LoginActivity.this, savedString, Toast.LENGTH_SHORT).show();
                //example: onActivityResult
//                setResult(Constants.LOGIN_RESULT);
                //example: Receiver
//                LocalBroadcastManager.getInstance(LoginActivity.this).sendBroadcast(new Intent(Constants.RESULT_KEY));
                //             finish();
            }
        });

        mEditTextView = findViewById(R.id.input_field_edit_text);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_DATA, savedString);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        savedString = savedInstanceState.getString(SAVED_DATA);
        super.onRestoreInstanceState(savedInstanceState);

    }
}
