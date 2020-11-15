package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChessResults(@JsonProperty("last") ChessStats last,
                           @JsonProperty("best") ChessStats best,
                           @JsonProperty("records") ChessRecords records)
{}
