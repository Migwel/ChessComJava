package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.streamer.Streamers;
import dev.migwel.chesscomjava.api.services.StreamerService;

public class StreamerServiceImpl implements StreamerService {

    private final ChessComFetcher fetcher;

    public StreamerServiceImpl() {
        fetcher = new ChessComFetcher(new HttpClient());
    }

    public StreamerServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Streamers getStreamers() {
        return fetcher.fetch("https://api.chess.com/pub/streamers", Streamers.class);
    }
}
