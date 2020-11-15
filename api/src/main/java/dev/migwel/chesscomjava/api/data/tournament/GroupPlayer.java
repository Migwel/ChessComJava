package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GroupPlayer(String username,
                          Float points,
                          @JsonProperty("tie_break") Float tieBreak,
                          @JsonProperty("is_advancing") Boolean isAdvancing)
{}
