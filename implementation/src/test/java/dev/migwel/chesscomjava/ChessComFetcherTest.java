package dev.migwel.chesscomjava;

import static org.mockito.Mockito.mock;

class ChessComFetcherTest {

    HttpHelper httpHelper = mock(HttpHelper.class);
    ChessComFetcher fetcher = new ChessComFetcher(httpHelper);


}