package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record ChessStats(@JsonProperty("rating") long rating,
                         @JsonProperty("date") Date date,
                         @JsonProperty("rd") long rd,
                         @JsonProperty("game") String game)
{}
