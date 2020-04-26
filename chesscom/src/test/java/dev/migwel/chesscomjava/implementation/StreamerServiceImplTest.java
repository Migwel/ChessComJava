package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.streamer.Streamer;
import dev.migwel.chesscomjava.api.streamer.Streamers;
import dev.migwel.chesscomjava.services.StreamerService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;


class StreamerServiceImplTest {

    private final HttpClient httpClient = mock(HttpClient.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private final StreamerService streamerService = new StreamerServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String streamersJson = FileUtil.loadFile("Streamers.json");
        when(httpClient.httpGet(contains("https://api.chess.com/pub/streamers"))).thenReturn(streamersJson);
    }

    @Test
    void getStreamers() {
        Streamers streamers = streamerService.getStreamers();
        assertEquals(streamers.streamers().size(), 240);
        Streamer streamer = streamers.streamers().iterator().next();
        assertEquals("https://images.chesscomfiles.com/uploads/v1/user/32076054.611f6b88.50x50o.b34120ef650c.jpeg", streamer.avatar());
        assertEquals("https://twitch.tv/GMBenjaminFinegold", streamer.twitchUrl());
        assertEquals("https://www.chess.com/member/GMBenjaminFinegold", streamer.url());
        assertEquals("GMBenjaminFinegold", streamer.username());
    }

}