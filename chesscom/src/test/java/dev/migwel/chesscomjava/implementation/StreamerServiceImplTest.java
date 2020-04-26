package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.streamer.Streamers;
import dev.migwel.chesscomjava.services.StreamerService;
import org.junit.jupiter.api.Test;

class StreamerServiceImplTest {

    private final HttpClient httpClient = new HttpClient();
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private final StreamerService streamerService = new StreamerServiceImpl(chessComFetcher);

    @Test
    void getStreamers() {
        Streamers streamers = streamerService.getStreamers();
        System.out.println(streamers);
    }

}