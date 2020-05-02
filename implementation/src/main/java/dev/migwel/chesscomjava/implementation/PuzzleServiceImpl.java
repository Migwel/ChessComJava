package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.puzzle.Puzzle;
import dev.migwel.chesscomjava.api.services.PuzzleService;

public class PuzzleServiceImpl implements PuzzleService {
    private final ChessComFetcher fetcher;

    public PuzzleServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Puzzle getDailyPuzzle() {
        return fetcher.fetch("https://api.chess.com/pub/puzzle", Puzzle.class);
    }

    @Override
    public Puzzle getRandomPuzzle() {
        return fetcher.fetch("https://api.chess.com/pub/puzzle/random", Puzzle.class);
    }
}
