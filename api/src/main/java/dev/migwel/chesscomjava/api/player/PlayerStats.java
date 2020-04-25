package dev.migwel.chesscomjava.api.player;

import com.google.gson.annotations.SerializedName;

public record PlayerStats(@SerializedName("chess_rapid") ChessResults rapidChessResults,
                         @SerializedName("chess_bullet") ChessResults bulletChessResults,
                         @SerializedName("chess_blitz") ChessResults blitzChessResults,
                         @SerializedName("chess960_daily") ChessResults chess960DailyResults,
                         @SerializedName("chess_daily") ChessResults chessDailyResults,
                         long fide,
                         @SerializedName("tactics") TacticsResults tacticsResults,
                         @SerializedName("lessons") TacticsResults lessonsResults,
                         @SerializedName("puzzle_rush") PuzzleRushResults puzzleRushResults)
{}