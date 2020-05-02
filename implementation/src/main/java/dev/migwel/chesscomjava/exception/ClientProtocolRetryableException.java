package dev.migwel.chesscomjava.exception;

import org.apache.http.client.ClientProtocolException;

public class ClientProtocolRetryableException extends ClientProtocolException {
    public ClientProtocolRetryableException(final String s) {
        super(s);
    }
}
