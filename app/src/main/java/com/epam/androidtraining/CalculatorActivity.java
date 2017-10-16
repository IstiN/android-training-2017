package com.epam.androidtraining;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private ICalculator mCalculator = new BackendCalculator();
    private TextView mResultTextView;
    private EditText mInputEditText;
    private View mCalculateButton;

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



    private void initView() {
        mInputEditText = (EditText) findViewById(R.id.input_field_edit_text);
        mCalculateButton = findViewById(R.id.calculate_button);
        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**/
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String result = mCalculator.evaluate(mInputEditText.getText().toString());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showResult(result);
                            }
                        });
                    }
                }).start();

               // new EndpointsAsyncTask().execute(new Pair<Context, String>(CalculatorActivity.this, "Manfred"));
//                new UserListLoader().execute(CalculatorActivity.this);
            }
        });

        mInputEditText.addTextChangedListener(new TextWatcher() {
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

        mResultTextView = (TextView) findViewById(R.id.result_text_view);
    }

    private void showResult(String result) {
        mResultTextView.setText(result);
    }


}
