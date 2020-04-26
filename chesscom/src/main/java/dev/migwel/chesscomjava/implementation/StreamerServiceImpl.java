package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.streamer.Streamers;
import dev.migwel.chesscomjava.services.StreamerService;

class StreamerServiceImpl implements StreamerService {

    private final ChessComFetcher fetcher;

    public StreamerServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Streamers getStreamers() {
        return fetcher.fetch("https://api.chess.com/pub/streamers", Streamers.class);
    }
}
