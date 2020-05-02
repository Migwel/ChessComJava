package dev.migwel.chesscomjava.api.services;

import dev.migwel.chesscomjava.api.data.puzzle.Puzzle;

public interface PuzzleService {
    Puzzle getDailyPuzzle();
    Puzzle getRandomPuzzle();
}
