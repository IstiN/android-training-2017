package com.epam.androidtraining.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.epam.androidtraining.R;
import com.epam.androidtraining.view.CustomSpinner;
import com.epam.androidtraining.view.SomeModel;
import com.epam.androidtraining.view.SpinnerAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GridViewActivity extends AppCompatActivity {

    private CustomSpinner mCategorySpinner;

    @Override
    protected void onCreate(@Nullable Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_grid_view);

        mCategorySpinner = (CustomSpinner) findViewById(R.id.spinner);
        List<SomeModel> data = new ArrayList<SomeModel>();
        data.add(new SomeModel("one", "one"));
        data.add(new SomeModel("two", "two"));

        SpinnerAdapter adapter = new SpinnerAdapter(data);
        mCategorySpinner.setAdapter(adapter);
        mCategorySpinner.setText("text");

       /* GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
            }
        });*/

    }










}
