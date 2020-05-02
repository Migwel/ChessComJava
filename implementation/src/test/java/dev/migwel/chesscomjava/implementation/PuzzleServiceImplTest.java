package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.HttpHelper;
import dev.migwel.chesscomjava.api.data.puzzle.Puzzle;
import dev.migwel.chesscomjava.api.services.PuzzleService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PuzzleServiceImplTest {

    private final HttpHelper httpHelper = mock(HttpHelper.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpHelper);
    private final PuzzleService puzzleService = new PuzzleServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String dailyPuzzleJson = FileUtil.loadFile("DailyPuzzle.json");
        String randomPuzzleJson = FileUtil.loadFile("RandomPuzzle.json");
        when(httpHelper.httpGet(contains("puzzle"))).thenReturn(dailyPuzzleJson);
        when(httpHelper.httpGet(contains("random"))).thenReturn(randomPuzzleJson);
    }

    @Test
    void testGetDailyPuzzle() {
        Puzzle puzzle = puzzleService.getDailyPuzzle();
        assertEquals("Magnetic Monarch", puzzle.title());
        assertEquals("https://www.chess.com/forum/view/daily-puzzles/5-2-2020-magnetic-monarch", puzzle.url());
        assertEquals("https://www.chess.com/dynboard?fen=r1kr4/p2nQppp/2pB4/1PR5/8/5pP1/q7/6K1%20w%20-%20-%200%201&size=2", puzzle.image());
        assertNotNull(puzzle.fen());
        assertNotNull(puzzle.pgn());
    }

    @Test
    void testGetRandomPuzzle() {
        Puzzle puzzle = puzzleService.getRandomPuzzle();
        assertEquals("The Sweet Spot", puzzle.title());
        assertEquals("https://www.chess.com/forum/view/daily-puzzles/12-25-2016-the-sweet-spot", puzzle.url());
        assertEquals("https://www.chess.com/dynboard?fen=1q1r1k2/7p/p2brB2/1p2ppNQ/7P/PP1PP1P1/5P2/2R1R1K1%20w%20-%20-%200%201&size=2", puzzle.image());
        assertNotNull(puzzle.fen());
        assertNotNull(puzzle.pgn());
    }

}