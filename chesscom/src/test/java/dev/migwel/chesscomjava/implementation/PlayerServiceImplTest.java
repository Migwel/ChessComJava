package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.api.player.Player;
import dev.migwel.chesscomjava.api.player.PlayerStats;
import dev.migwel.chesscomjava.api.player.TitledPlayers;
import dev.migwel.chesscomjava.services.PlayerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerServiceImplTest {

    private final PlayerService playerService = new PlayerServiceImpl();

    @Test
    void testGetProfile() {
        Player player = playerService.getProfile("mig_well");
        assertEquals(player.username(), "mig_well");
    }

    @Test
    void testGetTitledPlayers() {
        TitledPlayers titledPlayers = playerService.getTitledPlayers("GM");
        assertEquals(titledPlayers.players().size(), 1172);
    }

    @Test
    void testGetPlayerStats() {
        PlayerStats playerStats = playerService.getPlayerStats("mig_well");
        System.out.println(playerStats);
        assertEquals(playerStats.fide(), 0);
    }
}