package dev.migwel.chesscomjava.services;

import dev.migwel.chesscomjava.api.player.Player;
import dev.migwel.chesscomjava.api.player.PlayerStats;
import dev.migwel.chesscomjava.api.player.TitledPlayers;

public interface PlayerService {

    Player getProfile(String username);
    TitledPlayers getTitledPlayers(String title);
    PlayerStats getPlayerStats(String username);
}
