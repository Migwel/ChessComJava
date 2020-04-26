package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.games.PlayerArchives;
import dev.migwel.chesscomjava.api.games.PlayerGames;
import dev.migwel.chesscomjava.api.games.PlayerPastGames;
import dev.migwel.chesscomjava.services.GameService;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;

class GameServiceImplTest {
    private final HttpClient httpClient = new HttpClient();
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private final GameService gameService = new GameServiceImpl(chessComFetcher);

    @Test
    void testGetCurrentGames() {
        PlayerGames playerGames = gameService.getPlayerCurrentGames("erik");
        System.out.println(playerGames);
    }

    @Test
    void testGetGamesToMove() {
        PlayerGames playerGames = gameService.getPlayerGamesToMove("erik");
        System.out.println(playerGames);
    }

    @Test
    void testGetPastGames() {
        PlayerArchives playerGames = gameService.getPlayerPastGames("erik");
        System.out.println(playerGames);
    }

    @Test
    void testGetPastGamesInMonth() {
        YearMonth yearMonth = YearMonth.of(2009, 10);
        PlayerPastGames playerGames = gameService.getPlayerPastGames("erik", yearMonth);
        System.out.println(playerGames);
    }
}