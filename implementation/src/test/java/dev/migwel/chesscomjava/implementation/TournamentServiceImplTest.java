package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.tournament.*;
import dev.migwel.chesscomjava.api.services.StreamerService;
import dev.migwel.chesscomjava.api.services.TournamentService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TournamentServiceImplTest {

    private final HttpClient httpClient = mock(HttpClient.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private final TournamentService tournamentService = new TournamentServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String tournamentJson = FileUtil.loadFile("Tournament.json");
        String tournamentRoundJson = FileUtil.loadFile("TournamentRound.json");
        String roundGroupJson = FileUtil.loadFile("RoundGroup.json");
        when(httpClient.httpGet(contains("tournament"))).thenReturn(tournamentJson);
        when(httpClient.httpGet(contains("/1"))).thenReturn(tournamentRoundJson);
        when(httpClient.httpGet(contains("/1/1"))).thenReturn(roundGroupJson);
    }

    @Test
    void testGetTournament() {
        Tournament tournament = tournamentService.getTournament("-33rd-chesscom-quick-knockouts-1401-1600");
        assertEquals(399, tournament.players().size());
        assertEquals("Patzer24", tournament.creator());
        assertEquals("round_robin", tournament.settings().type());
    }

    @Test
    void testGetRound() {
        TournamentRound tournamentRound = tournamentService.getRound("-33rd-chesscom-quick-knockouts-1401-1600", "1");
        assertEquals(67, tournamentRound.groups().size());
        RoundPlayer player = tournamentRound.players().iterator().next();
        assertEquals("telo21", player.username());
        assertTrue(player.isAdvancing());
    }

    @Test
    void testGetGroup() {
        RoundGroup roundGroup = tournamentService.getGroup("-33rd-chesscom-quick-knockouts-1401-1600", "1", "1");
        assertEquals(5, roundGroup.players().size());
        GroupGame game = roundGroup.games().iterator().next();
        assertEquals("mrtn", game.black().username());
        GroupPlayer player = roundGroup.players().iterator().next();
        assertEquals("mrtn", player.username());
        assertFalse(player.isAdvancing());

    }
}