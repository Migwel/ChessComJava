package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.games.*;
import dev.migwel.chesscomjava.services.GameService;
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
    private final HttpClient httpClient = mock(HttpClient.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private final GameService gameService = new GameServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String currentGames = FileUtil.loadFile("CurrentGames.json");
        String gamesToMove = FileUtil.loadFile("GamesToMove.json");
        String pastGames = FileUtil.loadFile("PastGames.json");
        String pastGamesInMonth = FileUtil.loadFile("PastGamesInMonth.json");
        when(httpClient.httpGet(contains("games"))).thenReturn(currentGames);
        when(httpClient.httpGet(contains("to-move"))).thenReturn(gamesToMove);
        when(httpClient.httpGet(contains("archives"))).thenReturn(pastGames);
        when(httpClient.httpGet(contains("2009"))).thenReturn(pastGamesInMonth);
    }


    @Test
    void testGetCurrentGames() {
        PlayerGames playerGames = gameService.getPlayerCurrentGames("erik");
        assertEquals(playerGames.games().size(), 20);
        PlayerGame playerGame = playerGames.games().iterator().next();
        assertEquals(playerGame.black(), "https://api.chess.com/pub/player/erik");
        assertEquals(playerGame.rules(), "chess960");
    }

    @Test
    void testGetGamesToMove() {
        PlayerGames gamesToMove = gameService.getPlayerGamesToMove("erik");
        assertEquals(gamesToMove.games().size(), 5);
        PlayerGame gameToMove = gamesToMove.games().iterator().next();
        assertEquals(gameToMove.url(), "https://www.chess.com/daily/game/260767132");
    }

    @Test
    void testGetPastGames() {
        PlayerArchives pastGames = gameService.getPlayerPastGames("erik");
        assertEquals(pastGames.archives().size(), 154);
        String pastGame = pastGames.archives().iterator().next();
        assertEquals(pastGame, "https://api.chess.com/pub/player/erik/games/2007/07");
    }

    @Test
    void testGetPastGamesInMonth() {
        YearMonth yearMonth = YearMonth.of(2009, 10);
        PlayerPastGames pastGames = gameService.getPlayerPastGames("erik", yearMonth);
        assertEquals(pastGames.games().size(), 46);
        PlayerPastGame pastGame = pastGames.games().iterator().next();
        assertEquals(pastGame.url(), "https://www.chess.com/daily/game/29099782");
        assertEquals(pastGame.black().username(), "erik");
    }
}