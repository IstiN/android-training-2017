package com.epam.androidtraining.http;

import android.support.annotation.VisibleForTesting;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient implements IHttpClient {

    private HttpURLConnection con;

    @Override
    public void request(final String url, final ResponseListener listener) {
        try {
            final InputStream is = openStream(url);
            listener.onResponse(is);
            con.disconnect();
        } catch (final Throwable t) {
            listener.onError(t);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    @VisibleForTesting
    InputStream openStream(final String url) throws IOException {
        con = (HttpURLConnection) (new URL(url)).openConnection();
        return con.getInputStream();
    }

    public interface ResponseListener {
        void onResponse(InputStream pInputStream) throws Exception;
        void onError(Throwable pThrowable);
    }

}
