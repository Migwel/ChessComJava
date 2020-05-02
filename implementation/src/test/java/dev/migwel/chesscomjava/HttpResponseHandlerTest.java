package dev.migwel.chesscomjava;

import dev.migwel.chesscomjava.exception.ClientProtocolRetryableException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HttpResponseHandlerTest {

    HttpResponseHandler responseHandler = new HttpResponseHandler();

    @Test
    void test400StatusCode() throws IOException {
        HttpResponse response = getHttpResponse(400);
        try {
            responseHandler.handleResponse(response);
            fail();
        } catch (ClientProtocolException e) {
            assertEquals("Something went wrong with Http communication. Code: 400", e.getMessage());
        }
    }

    @Test
    void test404StatusCode() throws IOException {
        HttpResponse response = getHttpResponse(404);
        try {
            responseHandler.handleResponse(response);
            fail();
        } catch (ClientProtocolException e) {
            assertEquals("Resource could not be found", e.getMessage());
        }
    }

    @Test
    void test410StatusCode() throws IOException {
        HttpResponse response = getHttpResponse(410);
        try {
            responseHandler.handleResponse(response);
            fail();
        } catch (ClientProtocolException e) {
            assertEquals("The resource is no longer available at that URL", e.getMessage());
        }
    }

    @Test
    void test429StatusCode() throws IOException {
        HttpResponse response = getHttpResponse(429);
        try {
            responseHandler.handleResponse(response);
            fail();
        } catch (ClientProtocolException e) {
            assertEquals("Too many requests. We are being rate limited", e.getMessage());
            assertTrue(e instanceof ClientProtocolRetryableException);
        }
    }

    private HttpResponse getHttpResponse(int statusCode) {
        HttpResponse response = mock(HttpResponse.class);
        StatusLine statusLine = mock(StatusLine.class);
        when(response.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(statusCode);
        return response;
    }

}