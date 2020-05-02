package dev.migwel.chesscomjava;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpHelper {
    private static final Logger log = LoggerFactory.getLogger(HttpHelper.class);
    private final HttpClient httpClient;
    private final HttpResponseHandler responseHandler = new HttpResponseHandler();

    public HttpHelper(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String httpGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            return httpClient.execute(httpGet, responseHandler);
        } catch (IOException e) {
            log.info("Could not fetch data", e);
        }
        return "";
    }

}
