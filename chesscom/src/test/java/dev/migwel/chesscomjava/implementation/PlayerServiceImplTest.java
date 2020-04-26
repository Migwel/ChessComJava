package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.player.Player;
import dev.migwel.chesscomjava.api.player.PlayerStats;
import dev.migwel.chesscomjava.api.player.TitledPlayers;
import dev.migwel.chesscomjava.services.PlayerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerServiceImplTest {

    private final HttpClient httpClient = new HttpClient();
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private final PlayerService playerService = new PlayerServiceImpl(chessComFetcher);

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
        assertEquals(playerStats.fide(), 0);
    }

    @Test
    void testIsOnline() {
        boolean isOnline = playerService.isOnline("mig_well");
        assertTrue(isOnline);
    }
}