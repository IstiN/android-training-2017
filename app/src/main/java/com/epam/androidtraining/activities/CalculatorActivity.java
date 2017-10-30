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

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpressionView.append(((TextView) v).getText());
            }
        };
        findViewById(R.id.btn_1).setOnClickListener(clickListener);
        mExpressionView = findViewById(R.id.expression_text);

    }

}
