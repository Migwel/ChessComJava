package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.HttpHelper;
import dev.migwel.chesscomjava.api.data.games.*;
import dev.migwel.chesscomjava.api.services.GameService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameServiceImplTest {
    private final HttpHelper httpHelper = mock(HttpHelper.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpHelper);
    private final GameService gameService = new GameServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String currentGames = FileUtil.loadFile("CurrentGames.json");
        String gamesToMove = FileUtil.loadFile("GamesToMove.json");
        String pastGames = FileUtil.loadFile("PastGames.json");
        String pastGamesInMonth = FileUtil.loadFile("PastGamesInMonth.json");
        when(httpHelper.httpGet(contains("games"))).thenReturn(currentGames);
        when(httpHelper.httpGet(contains("to-move"))).thenReturn(gamesToMove);
        when(httpHelper.httpGet(contains("archives"))).thenReturn(pastGames);
        when(httpHelper.httpGet(contains("2009"))).thenReturn(pastGamesInMonth);
    }


    @Test
    void testGetCurrentGames() {
        PlayerGames playerGames = gameService.getPlayerCurrentGames("erik");
        assertEquals(20, playerGames.games().size());
        PlayerGame playerGame = playerGames.games().iterator().next();
        assertEquals("https://api.chess.com/pub/player/erik", playerGame.black());
        assertEquals("chess960", playerGame.rules());
    }

    @Test
    void testGetGamesToMove() {
        PlayerGames gamesToMove = gameService.getPlayerGamesToMove("erik");
        assertEquals(5, gamesToMove.games().size());
        PlayerGame gameToMove = gamesToMove.games().iterator().next();
        assertEquals("https://www.chess.com/daily/game/260767132", gameToMove.url());
    }

    @Test
    void testGetPastGames() {
        PlayerArchives pastGames = gameService.getPlayerPastGames("erik");
        assertEquals(154, pastGames.archives().size());
        String pastGame = pastGames.archives().iterator().next();
        assertEquals("https://api.chess.com/pub/player/erik/games/2007/07", pastGame);
    }

    @Test
    void testGetPastGamesInMonth() {
        YearMonth yearMonth = YearMonth.of(2009, 10);
        PlayerPastGames pastGames = gameService.getPlayerPastGames("erik", yearMonth);
        assertEquals(46, pastGames.games().size());
        PlayerPastGame pastGame = pastGames.games().iterator().next();
        assertEquals("https://www.chess.com/daily/game/29099782", pastGame.url());
        assertEquals("erik", pastGame.black().username());
    }
}