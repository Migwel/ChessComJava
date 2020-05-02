package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.leaderboard.Leaderboards;
import dev.migwel.chesscomjava.api.services.LeaderboardService;

public class LeaderboardServiceImpl implements LeaderboardService {
    private final ChessComFetcher fetcher;

    public LeaderboardServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Leaderboards getLeaderboards() {
        return fetcher.fetch("https://api.chess.com/pub/leaderboards", Leaderboards.class);
    }
}
