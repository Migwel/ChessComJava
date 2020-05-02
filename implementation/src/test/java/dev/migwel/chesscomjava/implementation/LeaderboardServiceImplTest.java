package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.leaderboard.LeaderboardPlayer;
import dev.migwel.chesscomjava.api.data.leaderboard.Leaderboards;
import dev.migwel.chesscomjava.api.services.LeaderboardService;
import dev.migwel.chesscomjava.api.services.StreamerService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LeaderboardServiceImplTest {

    private final HttpClient httpClient = mock(HttpClient.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private final LeaderboardService leaderboardService = new LeaderboardServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String leaderboardsJson = FileUtil.loadFile("Leaderboards.json");
        when(httpClient.httpGet(contains("leaderboards"))).thenReturn(leaderboardsJson);
    }

    @Test
    void testGetLeaderboards() {
        Leaderboards leaderboards = leaderboardService.getLeaderboards();
        assertEquals(50, leaderboards.daily().size());
        assertEquals(50, leaderboards.daily960().size());
        assertEquals(50, leaderboards.liveRapid().size());
        assertEquals(50, leaderboards.liveBlitz().size());
        assertEquals(50, leaderboards.liveBullet().size());
        assertEquals(50, leaderboards.liveBughouse().size());
        assertEquals(50, leaderboards.liveBlitz960().size());
        assertEquals(50, leaderboards.liveThreeCheck().size());
        assertEquals(50, leaderboards.liveCrazyHouse().size());
        assertEquals(50, leaderboards.liveKingOfTheHill().size());
        assertEquals(49, leaderboards.lessons().size()); //For some reasons, chess.com only returns 49 rows for lessons leaderboard...
        assertEquals(50, leaderboards.tactics().size());
        LeaderboardPlayer player = leaderboards.daily().iterator().next();
        assertEquals("francisbegbie", player.username());
    }

}