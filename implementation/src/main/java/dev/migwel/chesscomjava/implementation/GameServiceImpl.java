package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.games.PlayerArchives;
import dev.migwel.chesscomjava.api.data.games.PlayerGames;
import dev.migwel.chesscomjava.api.data.games.PlayerPastGames;
import dev.migwel.chesscomjava.api.services.GameService;

import java.time.YearMonth;

public class GameServiceImpl implements GameService {

    private final ChessComFetcher fetcher;

    public GameServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public PlayerGames getPlayerCurrentGames(String username) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/player/%s/games", username), PlayerGames.class);
    }

    @Override
    public PlayerGames getPlayerGamesToMove(String username) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/player/%s/games/to-move", username), PlayerGames.class);
    }

    @Override
    public PlayerArchives getPlayerPastGames(String username) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/player/%s/games/archives", username), PlayerArchives.class);
    }

    @Override
    public PlayerPastGames getPlayerPastGames(String username, YearMonth yearMonth) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/player/%s/games/%d/%d", username, yearMonth.getYear(), yearMonth.getMonthValue()), PlayerPastGames.class);
    }

    @Override
    public String getPgnFile(String username, YearMonth yearMonth) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/player/%s/games/%d/%d/pgn", username, yearMonth.getYear(), yearMonth.getMonthValue()));
    }
}
