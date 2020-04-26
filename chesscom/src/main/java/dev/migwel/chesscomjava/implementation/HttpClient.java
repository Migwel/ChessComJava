package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class HttpClient {
    private static final Logger log = LoggerFactory.getLogger(HttpClient.class);

    public String httpGet(String url) {
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
