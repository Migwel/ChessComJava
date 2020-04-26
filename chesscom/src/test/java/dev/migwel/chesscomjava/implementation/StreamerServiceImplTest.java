package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.api.streamer.Streamers;
import dev.migwel.chesscomjava.services.StreamerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamerServiceImplTest {

    private final StreamerService streamerService = new StreamerServiceImpl();

    @Test
    void getStreamers() {
        Streamers streamers = streamerService.getStreamers();
        System.out.println(streamers);
    }

}