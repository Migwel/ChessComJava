package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.player.Player;
import dev.migwel.chesscomjava.api.player.PlayerOnline;
import dev.migwel.chesscomjava.api.player.PlayerStats;
import dev.migwel.chesscomjava.api.player.TitledPlayers;
import dev.migwel.chesscomjava.services.PlayerService;

class PlayerServiceImpl implements PlayerService {

    private final ChessComFetcher fetcher;

    public PlayerServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Player getProfile(String username) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/player/%s", username), Player.class);
    }

    @Override
    public TitledPlayers getTitledPlayers(String title) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/titled/%s", title), TitledPlayers.class);
    }

    @Override
    public PlayerStats getPlayerStats(String username) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/player/%s/stats", username), PlayerStats.class);
    }

    @Override
    public boolean isOnline(String username) {
        PlayerOnline playerOnline = fetcher.fetch(String.format("https://api.chess.com/pub/player/%s/is-online", username), PlayerOnline.class);
        if (playerOnline == null) {
            return false;
        }
        return playerOnline.online();
    }
}
