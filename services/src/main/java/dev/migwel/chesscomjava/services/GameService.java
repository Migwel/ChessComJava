package dev.migwel.chesscomjava.services;

import dev.migwel.chesscomjava.api.games.PlayerArchives;
import dev.migwel.chesscomjava.api.games.PlayerGames;
import dev.migwel.chesscomjava.api.games.PlayerPastGames;

import java.time.YearMonth;

public interface GameService {
    PlayerGames getPlayerCurrentGames(String username);
    PlayerGames getPlayerGamesToMove(String username);
    PlayerArchives getPlayerPastGames(String username);
    PlayerPastGames getPlayerPastGames(String username, YearMonth yearMonth);
    void getPgnFile(String username, YearMonth yearMonth);
}
