package com.epam.androidtraining.http;

public interface IHttpClient {

    void request(String url, HttpClient.ResponseListener listener);
}
