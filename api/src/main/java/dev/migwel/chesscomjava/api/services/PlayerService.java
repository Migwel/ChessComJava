package dev.migwel.chesscomjava.api.services;

import dev.migwel.chesscomjava.api.data.player.Player;
import dev.migwel.chesscomjava.api.data.player.PlayerStats;
import dev.migwel.chesscomjava.api.data.player.TitledPlayers;

public interface PlayerService {

    Player getProfile(String username);
    TitledPlayers getTitledPlayers(String title);
    PlayerStats getPlayerStats(String username);
    boolean isOnline(String username);
}
