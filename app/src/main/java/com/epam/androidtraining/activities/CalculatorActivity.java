package com.epam.androidtraining.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epam.androidtraining.BackendCalculator;
import com.epam.androidtraining.Constants;
import com.epam.androidtraining.ICalculator;
import com.epam.androidtraining.R;
import com.epam.androidtraining.fragments.LoginFragment;
import com.epam.androidtraining.fragments.SuccessFragment;
import com.epam.androidtraining.services.CalcIntentService;
import com.epam.androidtraining.services.PlayerService;

public class CalculatorActivity extends AppCompatActivity {

    public static final String TAG = CalculatorActivity.class.getSimpleName();
    private ICalculator mCalculator = new BackendCalculator();
    private TextView mResultTextView;
    private EditText mFirstEdit;
    private View mCalculateButton;
    private EditText mSecondEdit;

    @Override
    protected void onCreate(@Nullable Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_calculator);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    // example onBackPresed
    /*@Override
    public void onBackPressed() {
        startActivity(new Intent(CalculatorActivity.this, MainActivity.class));
        finish();
    }
*/
    private void initView() {
        mFirstEdit = (EditText) findViewById(R.id.input_field_edit_text);
        mSecondEdit = (EditText) findViewById(R.id.second);
        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(CalculatorActivity.this, PlayerService.class));

                //example PendingIntent
                /*PendingIntent pi = createPendingResult(Constants.SERVICE_RESULT, new Intent(), 0);
                Intent intent = new Intent(CalculatorActivity.this, CalcIntentService.class);
                intent.putExtra(Constants.FIRST_KEY, Integer.valueOf(mFirstEdit.getText().toString()));
                intent.putExtra(Constants.SECOND_KEY, Integer.valueOf(mSecondEdit.getText().toString()));
                intent.putExtra(Constants.PI_KEY, pi);
                startService(intent);*/
            }
        });

        findViewById(R.id.stop_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(CalculatorActivity.this, PlayerService.class));
            }
        });

        mCalculateButton = findViewById(R.id.calculate_button);
        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**/
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String result = mCalculator.evaluate(mFirstEdit.getText().toString());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showResult(result);
                            }
                        });
                    }
                }).start();
*/
                showFragment(new LoginFragment());
                // new EndpointsAsyncTask().execute(new Pair<Context, String>(CalculatorActivity.this, "Manfred"));
//                new UserListLoader().execute(CalculatorActivity.this);
            }
        });

        mFirstEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                /*int length = editable.length();
                if (length > 0) {
                    mCalculateButton.setEnabled(true);
                } else {
                    mCalculateButton.setEnabled(false);
                }*/
            }
        });


    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        Log.i(TAG, "startActivityForResult: ");
        if (requestCode == Constants.SERVICE_RESULT) {
            Toast.makeText(this, "" + intent.getIntExtra(Constants.RESULT_KEY, 0), Toast.LENGTH_SHORT).show();
        }

        super.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "startActivityForResult: ");
        if (requestCode == Constants.SERVICE_RESULT) {
            Toast.makeText(this, "" + data.getIntExtra(Constants.RESULT_KEY, 0), Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void setLoginData() {
        showFragment(new SuccessFragment());
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private void showResult(String result) {
        mResultTextView.setText(result);
    }


}
