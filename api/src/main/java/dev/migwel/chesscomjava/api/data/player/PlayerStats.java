package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlayerStats(@JsonProperty("chess_rapid") ChessResults rapidChessResults,
                         @JsonProperty("chess_bullet") ChessResults bulletChessResults,
                         @JsonProperty("chess_blitz") ChessResults blitzChessResults,
                         @JsonProperty("chess960_daily") ChessResults chess960DailyResults,
                         @JsonProperty("chess_daily") ChessResults chessDailyResults,
                          @JsonProperty("fide") long fide,
                         @JsonProperty("tactics") TacticsResults tacticsResults,
                         @JsonProperty("lessons") TacticsResults lessonsResults,
                         @JsonProperty("puzzle_rush") PuzzleRushResults puzzleRushResults)
{}