package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TeamPlayer(@JsonProperty("username") String username,
                         @JsonProperty("board") String board,
                         @JsonProperty("stats") String stats,
                         @JsonProperty("rating") Long rating,
                         @JsonProperty("rd") Float rd,
                         @JsonProperty("timeout_percent") Float timeoutPercent,
                         @JsonProperty("status") String status,
                         @JsonProperty("played_as_white") String playedAsWhite,
                         @JsonProperty("played_as_black") String playedAsBlack)
{}
