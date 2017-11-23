package com.epam.training.imageloader;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStreamProvider implements StreamProvider<String> {
    @Override
    public InputStream get(String path) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) (new URL(path)).openConnection();
        return connection.getInputStream();
    }
}
