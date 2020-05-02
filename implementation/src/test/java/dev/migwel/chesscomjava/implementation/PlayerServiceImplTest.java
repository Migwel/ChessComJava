package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.HttpHelper;
import dev.migwel.chesscomjava.api.data.player.Player;
import dev.migwel.chesscomjava.api.data.player.PlayerStats;
import dev.migwel.chesscomjava.api.data.player.TitledPlayers;
import dev.migwel.chesscomjava.api.services.PlayerService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerServiceImplTest {

    private final HttpHelper httpHelper = mock(HttpHelper.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpHelper);
    private final PlayerService playerService = new PlayerServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String profile = FileUtil.loadFile("Profile.json");
        String titled = FileUtil.loadFile("Titled.json");
        String playerStats = FileUtil.loadFile("PlayerStats.json");
        String isOnline = FileUtil.loadFile("IsOnline.json");
        when(httpHelper.httpGet(contains("player"))).thenReturn(profile);
        when(httpHelper.httpGet(contains("titled"))).thenReturn(titled);
        when(httpHelper.httpGet(contains("stats"))).thenReturn(playerStats);
        when(httpHelper.httpGet(contains("online"))).thenReturn(isOnline);
    }

    @Test
    void testGetProfile() {
        Player player = playerService.getProfile("erik");
        assertEquals("erik", player.username());
        assertEquals("https://images.chesscomfiles.com/uploads/v1/user/41.f4cbdaf7.200x200o.2da5fc98b62f.jpeg", player.avatar());
        assertEquals(41, player.id());
        assertFalse(player.isStreamer());
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        assertEquals("2020-04-26T15:12:21", isoFormat.format(player.lastOnline()));
    }

    @Test
    void testGetTitledPlayers() {
        TitledPlayers titledPlayers = playerService.getTitledPlayers("GM");
        assertEquals(1173, titledPlayers.players().size());
        String titledPlayer = titledPlayers.players().iterator().next();
        assertEquals("124chess", titledPlayer);
    }

    @Test
    void testGetPlayerStats() {
        PlayerStats playerStats = playerService.getPlayerStats("erik");
        assertEquals(1707, playerStats.fide());
        assertEquals("https://www.chess.com/live/game/758005361", playerStats.rapidChessResults().best().game());
        assertEquals(40, playerStats.puzzleRushResults().best().score());
    }

    @Test
    void testIsOnline() {
        boolean isOnline = playerService.isOnline("erik");
        assertTrue(isOnline);
    }
}