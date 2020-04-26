package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.player.Player;
import dev.migwel.chesscomjava.api.player.PlayerStats;
import dev.migwel.chesscomjava.api.player.TitledPlayers;
import dev.migwel.chesscomjava.services.PlayerService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerServiceImplTest {

    private final HttpClient httpClient = mock(HttpClient.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private final PlayerService playerService = new PlayerServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String profile = FileUtil.loadFile("Profile.json");
        String titled = FileUtil.loadFile("Titled.json");
        String playerStats = FileUtil.loadFile("PlayerStats.json");
        String isOnline = FileUtil.loadFile("IsOnline.json");
        when(httpClient.httpGet(contains("player"))).thenReturn(profile);
        when(httpClient.httpGet(contains("titled"))).thenReturn(titled);
        when(httpClient.httpGet(contains("stats"))).thenReturn(playerStats);
        when(httpClient.httpGet(contains("online"))).thenReturn(isOnline);
    }

    @Test
    void testGetProfile() {
        Player player = playerService.getProfile("erik");
        assertEquals(player.username(), "erik");
        assertEquals(player.avatar(), "https://images.chesscomfiles.com/uploads/v1/user/41.f4cbdaf7.200x200o.2da5fc98b62f.jpeg");
        assertEquals(player.id(), 41);
        assertFalse(player.isStreamer());
    }

    @Test
    void testGetTitledPlayers() {
        TitledPlayers titledPlayers = playerService.getTitledPlayers("GM");
        assertEquals(titledPlayers.players().size(), 1173);
        String titledPlayer = titledPlayers.players().iterator().next();
        assertEquals(titledPlayer, "124chess");
    }

    @Test
    void testGetPlayerStats() {
        PlayerStats playerStats = playerService.getPlayerStats("erik");
        assertEquals(playerStats.fide(), 1707);
        assertEquals(playerStats.rapidChessResults().best().game(), "https://www.chess.com/live/game/758005361");
        assertEquals(playerStats.puzzleRushResults().best().score(), 40);
    }

    @Test
    void testIsOnline() {
        boolean isOnline = playerService.isOnline("erik");
        assertTrue(isOnline);
    }
}