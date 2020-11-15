package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RoundPlayer(@JsonProperty("username") String username,
                          @JsonProperty("is_advancing") Boolean isAdvancing)
{}
