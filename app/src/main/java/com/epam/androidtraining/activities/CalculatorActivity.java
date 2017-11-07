package com.epam.androidtraining.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.epam.androidtraining.R;
import com.epam.androidtraining.calculator.CalculationManager;
import com.epam.androidtraining.calculator.CalculationManager.CalculationResultListener;

public class CalculatorActivity extends AppCompatActivity {

    private TextView mExpressionView;
    private TextView mResultView;

    @Override
    protected void onCreate(@Nullable Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.calculactor_linear);

        mExpressionView = findViewById(R.id.expression_text);
        mResultView = findViewById(R.id.result_text);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpressionView.append(((TextView) v).getText());
            }
        };
        findViewById(R.id.btn_0).setOnClickListener(clickListener);
        findViewById(R.id.btn_1).setOnClickListener(clickListener);
        findViewById(R.id.btn_2).setOnClickListener(clickListener);
        findViewById(R.id.btn_3).setOnClickListener(clickListener);
        findViewById(R.id.btn_4).setOnClickListener(clickListener);
        findViewById(R.id.btn_5).setOnClickListener(clickListener);
        findViewById(R.id.btn_6).setOnClickListener(clickListener);
        findViewById(R.id.btn_7).setOnClickListener(clickListener);
        findViewById(R.id.btn_8).setOnClickListener(clickListener);
        findViewById(R.id.btn_9).setOnClickListener(clickListener);
        findViewById(R.id.btn_plus).setOnClickListener(clickListener);
        findViewById(R.id.btn_minus).setOnClickListener(clickListener);
        findViewById(R.id.btn_multiply).setOnClickListener(clickListener);
        findViewById(R.id.btn_divide).setOnClickListener(clickListener);
        findViewById(R.id.btn_dot).setOnClickListener(clickListener);

        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClearEvent();
            }
        });
        findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDeleteEvent();
            }
        });
        findViewById(R.id.btn_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleEqualsEvent();
            }
        });

    }

    private void handleEqualsEvent() {
        String input = mExpressionView.getText().toString();
        CalculationManager.getInstance().calculate(input, new CalculationResultListener() {
            @Override
            public void onSuccess(String result) {
                mResultView.setText(result);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    private void handleClearEvent() {
        mExpressionView.setText("");
    }

    private void handleDeleteEvent() {
        CharSequence text = mExpressionView.getText();
        if (text.length() > 0) {
            mExpressionView.setText(text.subSequence(0, text.length() - 1));
        }
    }

}
