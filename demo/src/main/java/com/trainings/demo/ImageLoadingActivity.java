package com.trainings.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.epam.training.imageloader.Malevich;
import com.warkiz.widget.IndicatorSeekBar;


public class ImageLoadingActivity extends AppCompatActivity {

    public static final String URL_FORMAT = "http://lorempixel.com/%s/%s/sports/2/";

    private IndicatorSeekBar widthBar;
    private IndicatorSeekBar heightBar;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_loading_activity);
        widthBar = findViewById(R.id.width_bar);
        heightBar = findViewById(R.id.height_bar);
        imageView = findViewById(R.id.image_view);

        findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getUrl(widthBar.getProgress(), heightBar.getProgress());
                Malevich.INSTANCE.load(url).into(imageView);
            }
        });
    }

    private String getUrl(int width, int height) {
        return String.format(URL_FORMAT, width, height);
    }
}
