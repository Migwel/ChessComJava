package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.streamer.Streamers;
import dev.migwel.chesscomjava.services.StreamerService;

class StreamerServiceImpl implements StreamerService {

    @Override
    public Streamers getStreamers() {
        return ChessComFetcher.fetch("https://api.chess.com/pub/streamers", Streamers.class);
    }
}
