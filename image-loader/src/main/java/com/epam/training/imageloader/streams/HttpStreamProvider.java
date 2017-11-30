package com.epam.training.imageloader.streams;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStreamProvider implements StreamProvider<String> {

    private static final int READ_TIMEOUT = 30 * 1000;
    private static final int CONNECT_TIMEOUT = 10 * 1000;

    @Override
    public InputStream get(String path) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) (new URL(path)).openConnection();
        connection.setConnectTimeout(CONNECT_TIMEOUT);
        connection.setReadTimeout(READ_TIMEOUT);
        return connection.getInputStream();
    }
}
