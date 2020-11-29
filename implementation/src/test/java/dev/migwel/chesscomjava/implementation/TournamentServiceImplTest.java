package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.HttpHelper;
import dev.migwel.chesscomjava.api.data.tournament.*;
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

    private final HttpHelper httpHelper = mock(HttpHelper.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpHelper);
    private final TournamentService tournamentService = new TournamentServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String tournamentJson = FileUtil.loadFile("Tournament.json");
        String tournamentRoundJson = FileUtil.loadFile("TournamentRound.json");
        String roundGroupWhiteBlackObjectJson = FileUtil.loadFile("RoundGroupWhiteBlackObject.json");
        String roundGroupWhiteBlackStringJson = FileUtil.loadFile("RoundGroupWhiteBlackString.json");
        when(httpHelper.httpGet(contains("tournament"))).thenReturn(tournamentJson);
        when(httpHelper.httpGet(contains("/1"))).thenReturn(tournamentRoundJson);
        when(httpHelper.httpGet(contains("/1/1"))).thenReturn(roundGroupWhiteBlackObjectJson);
        when(httpHelper.httpGet(contains("-33rd-chesscom-quick-knockouts-1401-1600/1/1"))).thenReturn(roundGroupWhiteBlackObjectJson);
        when(httpHelper.httpGet(contains("5th-chess-com-chess960-quick-knockouts-under-1000/1/1"))).thenReturn(roundGroupWhiteBlackStringJson);
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

    /*
     * chess.com is not consistent with how they represent white/black values in their group. Sometimes it's an object, sometimes it's a string...
     * See https://www.chess.com/clubs/forum/view/inconsistency-in-white-black-format-in-tournamentroundgroup for more info
     */
    @Test
    void testGetGroup_ObjectWhiteBlack() {
        RoundGroup roundGroup = tournamentService.getGroup("-33rd-chesscom-quick-knockouts-1401-1600", "1", "1");
        assertEquals(5, roundGroup.players().size());
        GroupGame game = roundGroup.games().iterator().next();
        assertEquals("mrtn", game.black().username());
        GroupPlayer player = roundGroup.players().iterator().next();
        assertEquals("mrtn", player.username());
        assertFalse(player.isAdvancing());
    }

    @Test
    void testGetGroup_StringWhiteBlack() {
        RoundGroup roundGroup = tournamentService.getGroup("5th-chess-com-chess960-quick-knockouts-under-1000", "1", "1");
        assertEquals(5, roundGroup.players().size());
        GroupGame game = roundGroup.games().iterator().next();
        assertEquals("mainak_roy", game.black().username());
        GroupPlayer player = roundGroup.players().iterator().next();
        assertEquals("gs20598", player.username());
        assertFalse(player.isAdvancing());
    }
}