package com.epam.androidtraining.http;

import java.io.InputStream;

public interface IHttpClient {

    InputStream request(String url);
}
