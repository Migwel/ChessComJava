package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PuzzleRushStats(@JsonProperty("total_attempts") Integer totalAttempts,
                              @JsonProperty("score") Integer score)
{}
