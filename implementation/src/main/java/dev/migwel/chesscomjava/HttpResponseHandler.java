package dev.migwel.chesscomjava;

import dev.migwel.chesscomjava.exception.ClientProtocolRetryableException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpResponseHandler implements ResponseHandler<String> {
    @Override
    public String handleResponse(HttpResponse response) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode < 200 || statusCode > 304) {
            handleWrongStatusCode(statusCode);
        }
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    private void handleWrongStatusCode(int statusCode) throws ClientProtocolException {
        switch (statusCode) {
            case 404 -> throw new ClientProtocolException("Resource could not be found");
            case 410 -> throw new ClientProtocolException("The resource is no longer available at that URL");
            case 429 -> throw new ClientProtocolRetryableException("Too many requests. We are being rate limited");
        }
        throw new ClientProtocolException("Something went wrong with Http communication. Code: "+ statusCode);
    }
}
