package com.epam.androidtraining.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.epam.androidtraining.R;

public class CalculatorActivity extends AppCompatActivity {

    private TextView mExpressionView;

    @Override
    protected void onCreate(@Nullable Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.calculactor_linear);

        mExpressionView = findViewById(R.id.expression_text);
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
                mExpressionView.setText("");
            }
        });
        findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = mExpressionView.getText();
                if (text.length() > 0) {
                    mExpressionView.setText(text.subSequence(0, text.length() - 1));
                }
            }
        });

    }

}
