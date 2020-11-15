package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PuzzleRushResults(@JsonProperty("daily") PuzzleRushStats daily,
                                @JsonProperty("best") PuzzleRushStats best)
{}
