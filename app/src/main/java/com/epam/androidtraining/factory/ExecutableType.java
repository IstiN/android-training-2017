package com.epam.androidtraining.factory;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static com.epam.androidtraining.factory.ExecutableType.EXECUTABLE;
import static com.epam.androidtraining.factory.ExecutableType.THREAD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@StringDef({THREAD, EXECUTABLE})
public @interface ExecutableType {
    public static final String THREAD = "thread";
    public static final String EXECUTABLE = "executable";
}
