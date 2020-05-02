package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.HttpHelper;
import dev.migwel.chesscomjava.api.data.match.Board;
import dev.migwel.chesscomjava.api.data.match.BoardGame;
import dev.migwel.chesscomjava.api.data.match.Match;
import dev.migwel.chesscomjava.api.data.match.TeamPlayer;
import dev.migwel.chesscomjava.api.services.MatchService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MatchServiceImplTest {

    private final HttpHelper httpHelper = mock(HttpHelper.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpHelper);
    private final MatchService matchService = new MatchServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String matchJson = FileUtil.loadFile("Match.json");
        String liveMatchJson = FileUtil.loadFile("LiveMatch.json");
        String boardJson = FileUtil.loadFile("Board.json");
        String liveBoardJson = FileUtil.loadFile("LiveBoard.json");
        when(httpHelper.httpGet(contains("match"))).thenReturn(matchJson);
        when(httpHelper.httpGet(contains("12803/1"))).thenReturn(boardJson);
        when(httpHelper.httpGet(contains("live"))).thenReturn(liveMatchJson);
        when(httpHelper.httpGet(contains("5833/5"))).thenReturn(liveBoardJson);
    }


    @Test
    void testGetMatch() {
        Match match = matchService.getMatch("12803");
        assertEquals("WORLD LEAGUE Round 5: Romania vs USA Southwest", match.name());
        assertEquals(54, match.teams().team1().players().size());
        TeamPlayer player = match.teams().team1().players().iterator().next();
        assertEquals("aayeah-bwoy", player.username());
    }

    @Test
    void testGetBoard() {
        Board board = matchService.getBoard("12803", "1");
        assertEquals(2, board.games().size());
        BoardGame boardGame = board.games().iterator().next();
        assertEquals("Kllr", boardGame.black().username());
        assertEquals(1f, board.boardScores().get("kllr"));
    }

    @Test
    void testGetLiveMatch() {
        Match match = matchService.getLiveMatch("5833");
        assertEquals("Friendly 5+2", match.name());
        assertEquals(6, match.teams().team1().players().size());
        TeamPlayer player = match.teams().team1().players().iterator().next();
        assertEquals("guilhermekk", player.username());
    }

    @Test
    void testGetLiveBoard() {
        Board board = matchService.getLiveBoard("5833", "5");
        assertEquals(2, board.games().size());
        BoardGame boardGame = board.games().iterator().next();
        assertEquals("JYDRA21", boardGame.black().username());
    }

}