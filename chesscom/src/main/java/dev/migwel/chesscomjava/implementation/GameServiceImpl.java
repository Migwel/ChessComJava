package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.games.PlayerArchives;
import dev.migwel.chesscomjava.api.games.PlayerGames;
import dev.migwel.chesscomjava.api.games.PlayerPastGames;
import dev.migwel.chesscomjava.services.GameService;

import java.time.YearMonth;

class GameServiceImpl implements GameService {
    @Override
    public PlayerGames getPlayerCurrentGames(String username) {
        return ChessComFetcher.fetch(String.format("https://api.chess.com/pub/player/%s/games", username), PlayerGames.class);
    }

    @Override
    public PlayerGames getPlayerGamesToMove(String username) {
        return ChessComFetcher.fetch(String.format("https://api.chess.com/pub/player/%s/games/to-move", username), PlayerGames.class);
    }

    @Override
    public PlayerArchives getPlayerPastGames(String username) {
        return ChessComFetcher.fetch(String.format("https://api.chess.com/pub/player/%s/games/archives", username), PlayerArchives.class);
    }

    @Override
    public PlayerPastGames getPlayerPastGames(String username, YearMonth yearMonth) {
        return ChessComFetcher.fetch(String.format("https://api.chess.com/pub/player/%s/games/%d/%d", username, yearMonth.getYear(), yearMonth.getMonthValue()), PlayerPastGames.class);
    }

    @Override
    public void getPgnFile(String username, YearMonth yearMonth) {
        throw new UnsupportedOperationException(); //TODO
    }
}
