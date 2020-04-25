package dev.migwel.chesscomjava;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dev.migwel.chesscomjava.implementation.PlayerServiceImpl;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class ChessComFetcher {
    private static final Logger log = LoggerFactory.getLogger(ChessComFetcher.class);
    private static final Gson gson = new Gson();

    public static <T> T fetch(String url, Class<T> responseClass) {
        String response = ChessComFetcher.httpGet(url);
        T responseObject;
        try {
            responseObject = gson.fromJson(response, responseClass);
        } catch (JsonSyntaxException e) {
            log.warn("Could not deserialize response to "+ responseClass, e);
            return null;
        }
        return responseObject;
    }

    public static String httpGet(String url) {
        StringBuilder sb = new StringBuilder();
        HttpGet httpGet = new HttpGet(url);
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            Scanner sc = new Scanner(response.getEntity().getContent());
            while(sc.hasNext()) {
                sb.append(sc.nextLine());
            }
        } catch (IOException e) {
            log.info("Could not fetch data", e);
        }

        return sb.toString();
    }
}
