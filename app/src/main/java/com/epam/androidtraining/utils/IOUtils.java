package com.epam.androidtraining.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.OutputStream;

public class IOUtils {

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                //can be ignored
                Log.e("IOUtils", e.getMessage());
            }
        }
    }

    public static void close(ObjectOutput closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                //can be ignored
                Log.e("IOUtils", e.getMessage());
            }
        }
    }

    public static void close(ObjectInput closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                //can be ignored
                Log.e("IOUtils", e.getMessage());
            }
        }
    }

    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    public static long copy(InputStream input, File file) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            return copy(input, fileOutputStream);
        } finally {
            close(fileOutputStream);
        }
    }

    public static long copy(InputStream input, OutputStream output) throws IOException {
        return copy(input, output, new byte[DEFAULT_BUFFER_SIZE]);
    }

    public static long copy(InputStream input, OutputStream output, byte[] buffer) throws IOException {
        long count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static String toString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } finally {
            close(inputStream);
            close(inputStreamReader);
            close(reader);
        }
        return sb.toString();
    }
}
