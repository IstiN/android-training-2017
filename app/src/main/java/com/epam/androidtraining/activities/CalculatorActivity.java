package com.epam.androidtraining.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.epam.androidtraining.R;
import com.epam.androidtraining.builder.BuilderExample;
import com.epam.androidtraining.builder.BuilderExampleBuilder;
import com.epam.androidtraining.factory.AbstractExecutableFactory;
import com.epam.androidtraining.factory.ExecutorThreadCreator;
import com.epam.androidtraining.calculator.CalculationManager;
import com.epam.androidtraining.calculator.CalculationManager.CalculationResultListener;
import com.epam.androidtraining.factory.Executable;
import com.epam.androidtraining.factory.ExecutableType;
import com.epam.androidtraining.factory.ExecutorExecutableCreator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity {

    private TextView mExpressionView;
    private TextView mResultView;
    private View mProgressView;

    @Override
    protected void onCreate(@Nullable Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.calculactor_linear);

        mExpressionView = findViewById(R.id.expression_text);
        mResultView = findViewById(R.id.result_text);
        mProgressView = findViewById(R.id.progress_bar);
        mProgressView.setVisibility(View.INVISIBLE);

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
                /*List<Integer> list = new ArrayList<>();
                list.add(12);
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()) {
                    Integer next = iterator.next();
                    list.remove(next);
                    iterator.remove();
                }

                BuilderExample builderExample = new BuilderExample("kajkj", "jsjs", "ksk", "ksk");
                try {
                    Object clone = builderExample.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

                AlertDialog.Builder dialog = new AlertDialog.Builder(CalculatorActivity.this);
                dialog.setTitle("Hello")
                        .setMessage("hi")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .create()
                        .show();
*/

                handleEqualsEvent();
            }
        });

    }

    private void handleEqualsEvent() {
        mProgressView.setVisibility(View.VISIBLE);
        String input = mExpressionView.getText().toString();
        Executable executable = getExecutable(ExecutableType.THREAD, input);
        CalculationManager.getInstance().calculate(executable);
    }

    private Executable getExecutable(@ExecutableType String type, String input) {
        AbstractExecutableFactory factory = null;
        switch (type){
            case(ExecutableType.THREAD): {
                factory = new ExecutorThreadCreator();
                break;
            }
            case(ExecutableType.EXECUTABLE): {
                factory = new ExecutorExecutableCreator();
                break;
            }
        }

        return factory == null ? null : factory.createExecutable(input, new CalculationResultListener() {
            @Override
            public void onSuccess(final String result) {
                setResult(result);
            }

            @Override
            public void onError(final Throwable throwable) {
                setResult(throwable.getMessage());
            }
        });
    }

    private void setResult(final String result) {
        mProgressView.setVisibility(View.INVISIBLE);
        mResultView.setText(result);
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
