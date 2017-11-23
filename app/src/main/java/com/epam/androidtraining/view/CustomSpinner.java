package com.epam.androidtraining.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.epam.androidtraining.R;

public class CustomSpinner extends LinearLayout implements View.OnClickListener {

    private TextView text;
    private SpinnerAdapter adapter;
    private SpinnerAdapter.OnItemSelectedListener onItemSelectedListener;
    private PopupWindow popupWindow;

    public CustomSpinner(Context context) {
        super(context);
        if (isInEditMode()) {
            return;
        }
        init(context, null);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            return;
        }
        init(context, attrs);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            return;
        }
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (isInEditMode()) {
            return;
        }
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        show();
    }

    private void onItemSelected() {
        dismiss();
    }

    private void onNothingSelected() {
        dismiss();
    }

    private void dismiss() {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private void show() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        popupWindow = new PopupWindow(recyclerView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(this);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                if (onItemSelectedListener != null) {
                    onItemSelectedListener.onNothingSelected();
                }
                dismiss();
            }
        });
    }

    public void setOnItemSelectedListener(final SpinnerAdapter.OnItemSelectedListener listener) {
        this.onItemSelectedListener = new SpinnerAdapter.OnItemSelectedListener() {

            @Override
            public void onItemSelected(View view, int position) {
                listener.onItemSelected(view, position);
                CustomSpinner.this.onItemSelected();
            }

            @Override
            public void onNothingSelected() {
                listener.onNothingSelected();
                CustomSpinner.this.onNothingSelected();
            }
        };
        if (adapter != null) {
            adapter.setOnItemSelectedListener(onItemSelectedListener);
        }
    }

    public void setAdapter(SpinnerAdapter adapter) {
        this.adapter = adapter;
        if (onItemSelectedListener != null) {
            adapter.setOnItemSelectedListener(onItemSelectedListener);
        }
    }

    public void setText(String txt) {
        text = (TextView) findViewById(R.id.text);
        text.setText(txt);
    }

    public void setText(int stringId) {
        text = (TextView) findViewById(R.id.text);
        text.setText(stringId);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        text = (TextView) findViewById(R.id.text);
        text.setSelected(selected);
    }
}
