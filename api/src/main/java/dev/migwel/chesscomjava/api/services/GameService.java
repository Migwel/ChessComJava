package dev.migwel.chesscomjava.api.services;

import dev.migwel.chesscomjava.api.data.games.PlayerArchives;
import dev.migwel.chesscomjava.api.data.games.PlayerGames;
import dev.migwel.chesscomjava.api.data.games.PlayerPastGames;

import java.time.YearMonth;

public interface GameService {
    PlayerGames getPlayerCurrentGames(String username);
    PlayerGames getPlayerGamesToMove(String username);
    PlayerArchives getPlayerPastGames(String username);
    PlayerPastGames getPlayerPastGames(String username, YearMonth yearMonth);
    String getPgnFile(String username, YearMonth yearMonth);
}
