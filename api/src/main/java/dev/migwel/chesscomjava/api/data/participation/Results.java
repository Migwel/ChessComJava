package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Results(@JsonProperty("played_as_white") String playedAsWhite,
                      @JsonProperty("played_as_black") String playedAsBlack)
{}
