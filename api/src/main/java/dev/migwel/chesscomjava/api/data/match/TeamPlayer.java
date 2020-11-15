package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TeamPlayer(String username,
                         String board,
                         String stats,
                         Long rating,
                         Float rd,
                         @JsonProperty("timeout_percent") Float timeoutPercent,
                         String status,
                         @JsonProperty("played_as_white") String playedAsWhite,
                         @JsonProperty("played_as_black") String playedAsBlack)
{}
