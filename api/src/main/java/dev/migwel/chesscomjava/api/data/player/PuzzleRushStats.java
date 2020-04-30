package dev.migwel.chesscomjava.api.data.player;

import com.google.gson.annotations.SerializedName;

public record PuzzleRushStats(@SerializedName("total_attempts") Integer totalAttempts,
                              Integer score)
{}
