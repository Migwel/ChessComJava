package dev.migwel.chesscomjava;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dev.migwel.chesscomjava.implementation.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessComFetcher {
    private static final Logger log = LoggerFactory.getLogger(ChessComFetcher.class);
    private final HttpClient httpClient;
    private static final Gson gson = new Gson();

    public ChessComFetcher(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public <T> T fetch(String url, Class<T> responseClass) {
        String response = httpClient.httpGet(url);
        T responseObject;
        try {
            responseObject = gson.fromJson(response, responseClass);
        } catch (JsonSyntaxException e) {
            log.warn("Could not deserialize response to "+ responseClass, e);
            return null;
        }
        return responseObject;
    }


}