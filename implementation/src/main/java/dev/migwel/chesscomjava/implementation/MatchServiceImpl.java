package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.match.Board;
import dev.migwel.chesscomjava.api.data.match.Match;
import dev.migwel.chesscomjava.api.data.participation.Clubs;
import dev.migwel.chesscomjava.api.data.streamer.Streamers;
import dev.migwel.chesscomjava.api.services.MatchService;
import dev.migwel.chesscomjava.api.services.StreamerService;

public class MatchServiceImpl implements MatchService {

    private final ChessComFetcher fetcher;

    public MatchServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Match getMatch(String id) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/match/%s", id), Match.class);
    }

    @Override
    public Match getLiveMatch(String id) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/match/live/%s", id), Match.class);
    }

    @Override
    public Board getBoard(String matchId, String boardId) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/match/%s/%s", matchId, boardId), Board.class);
    }

    @Override
    public Board getLiveBoard(String matchId, String boardId) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/match/live/%s/%s", matchId, boardId), Board.class);
    }
}
