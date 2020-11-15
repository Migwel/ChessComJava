package dev.migwel.chesscomjava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessComFetcher {
    private static final Logger log = LoggerFactory.getLogger(ChessComFetcher.class);
    private final HttpHelper httpHelper;
    private static final ObjectMapper objectMapper = getObjectMapper();

    private static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    public ChessComFetcher(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    public <T> T fetch(String url, Class<T> responseClass) {
        String response = httpHelper.httpGet(url);
        T responseObject;
        try {
            responseObject = objectMapper.readValue(response, responseClass);
        } catch (JsonProcessingException e) {
            log.warn("Could not deserialize response to "+ responseClass, e);
            return null;
        }
        return responseObject;
    }

    public String fetch(String url) {
        return httpHelper.httpGet(url);
    }
}
